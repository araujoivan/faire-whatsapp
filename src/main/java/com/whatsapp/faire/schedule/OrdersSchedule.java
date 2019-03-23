package com.whatsapp.faire.schedule;

import com.whatsapp.faire.model.Client;
import com.whatsapp.faire.model.Order;
import com.whatsapp.faire.service.ClientService;
import com.whatsapp.faire.service.OrderService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.whatsapp.faire.service.WhatsappSenderService;

/**
 *
 * @author eder
 */
@Component
public class OrdersSchedule {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private WhatsappSenderService whatsappService;

    @Scheduled(fixedDelay = 10000)
    public void trackTransitionFromNewToProcessing() {

        final List<Order> newOrders = orderService.getAllNewOrders();

        if (!newOrders.isEmpty()) {

            final Map<Client, List<Order>> clientOrdersMap = clientService.getGroupedOrdersByClient(newOrders);

            if (!clientOrdersMap.isEmpty()) {
                whatsappService.sendTransitionFromNewToProcessingStateMessage(clientOrdersMap);
            }
        }
    }
}
