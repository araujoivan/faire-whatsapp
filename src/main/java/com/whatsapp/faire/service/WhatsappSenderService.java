package com.whatsapp.faire.service;

import com.whatsapp.faire.model.Client;
import com.whatsapp.faire.model.Order;
import java.util.List;
import java.util.Map;

/**
 *
 * @author eder
 */
public interface WhatsappSenderService {

    public void sendTransitionFromNewToProcessingStateMessage(Map<Client, List<Order>> clientOrdersMap);
    
}
