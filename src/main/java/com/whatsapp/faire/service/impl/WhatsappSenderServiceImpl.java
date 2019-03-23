package com.whatsapp.faire.service.impl;

import com.whatsapp.faire.model.Client;
import com.whatsapp.faire.model.Message;
import com.whatsapp.faire.model.Order;
import com.whatsapp.faire.model.WhatsappMessageResponse;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.whatsapp.faire.service.WhatsappHistoryMessageService;
import com.whatsapp.faire.service.WhatsappSenderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author eder
 */
@Service
public class WhatsappSenderServiceImpl implements WhatsappSenderService {

    @Value("${faire.base-mobile-number}")
    private String faireBaseMobileNumber;
    
    @Value("${whatsapp.api.token}")
    private String whatsappToken;

    @Value("${whatsapp.api.base-url}")
    private String whatsappApiBaseUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WhatsappHistoryMessageService historicalWhatsappMessageService;

    @Override
    public void sendTransitionFromNewToProcessingStateMessage(Map<Client, List<Order>> clientOrdersMap) {

        final Map<Client, List<Order>> eligibleClientOrdersMap = historicalWhatsappMessageService.getAllNewToProcessingStatusOrdersNotSentYet(clientOrdersMap);

        if (!eligibleClientOrdersMap.isEmpty()) {
            sendTransitionFromNewToProcessingMessage(eligibleClientOrdersMap);
        }
    }

    private void sendTransitionFromNewToProcessingMessage(Map<Client, List<Order>> eligibleClientOrdersMap) {

        eligibleClientOrdersMap.keySet().forEach(key -> {

            // TODO:  We need to deal with all order, however for tests purpose we get just the first.
            final Order order = eligibleClientOrdersMap.get(key).get(0);

            final Message message = new Message();
            
            message.setCustom_uid(order.getId());
            message.setText("Hi ".concat(key.getName()).concat(", your order ").concat(order.getId()).concat(" has been accepted by the maker. Stay tune for the next interactions!"));
            message.setTo(key.getMobileNumber());
            message.setToken(whatsappToken);
            message.setUid(faireBaseMobileNumber);
            
            final HttpEntity<Message> entity = new HttpEntity(message);

            final ResponseEntity<WhatsappMessageResponse> response = restTemplate.exchange(whatsappApiBaseUrl, HttpMethod.POST, entity, WhatsappMessageResponse.class);
            
            historicalWhatsappMessageService.saveProcessedTransiotionOrder(key, response.getBody());
            
        });
    }
}
