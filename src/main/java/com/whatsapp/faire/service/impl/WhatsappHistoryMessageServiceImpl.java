package com.whatsapp.faire.service.impl;

import com.whatsapp.faire.model.Client;
import com.whatsapp.faire.model.Order;
import com.whatsapp.faire.model.WhatsappMessageResponse;
import com.whatsapp.faire.service.WhatsappHistoryMessageService;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author eder
 */

@Service
public class WhatsappHistoryMessageServiceImpl implements WhatsappHistoryMessageService {

    @Override
    public Map<Client, List<Order>> getAllNewToProcessingStatusOrdersNotSentYet(Map<Client, List<Order>> clientOrdersMap) {
        
        // TODO: Filter all orders wich is not persisted in the database        
        return clientOrdersMap;
    }

    @Override
    public void saveProcessedTransiotionOrder(Client client, WhatsappMessageResponse body) {
        // TODO: Save the message sent into history.
    }
    
}
