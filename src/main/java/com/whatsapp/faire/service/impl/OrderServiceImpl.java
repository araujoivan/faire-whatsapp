package com.whatsapp.faire.service.impl;

import com.whatsapp.faire.constant.OrderStatus;
import com.whatsapp.faire.model.Order;
import com.whatsapp.faire.model.OrderPage;
import com.whatsapp.faire.service.OrderService;
import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.nonNull;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author eder
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${faire.api.base-url}")
    private String baseUrl;

    @Override
    public List<Order> getAllNewOrders() {

        final String queryUrl = baseUrl.concat("orders?limit=50&page=");

        final List<Order> orders = new ArrayList();

        int pageNumber = 1;

        boolean hasResults = true;

        do {

            final ResponseEntity<OrderPage> response
                    = restTemplate.getForEntity(queryUrl.concat(String.valueOf(pageNumber++)), OrderPage.class);

            hasResults = nonNull(response.getBody())
                    && nonNull(response.getBody().getOrders())
                    && !response.getBody().getOrders().isEmpty();

            if (hasResults) {
                orders.addAll(response.getBody().getOrders().stream()
                        .filter(order -> order.getState().equals(OrderStatus.PROCESSING.name()))
                        .collect(Collectors.toList()));
            }

        } while (hasResults);

        return orders;
    } 
}
