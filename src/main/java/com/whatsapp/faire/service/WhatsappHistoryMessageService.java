package com.whatsapp.faire.service;

import com.whatsapp.faire.model.Client;
import com.whatsapp.faire.model.Order;
import com.whatsapp.faire.model.WhatsappMessageResponse;
import java.util.List;
import java.util.Map;

/**
 *
 * @author eder
 */
public interface WhatsappHistoryMessageService {

    public Map<Client, List<Order>> getAllNewToProcessingStatusOrdersNotSentYet(Map<Client, List<Order>> clientOrdersMap);

    public void saveProcessedTransiotionOrder(Client key, WhatsappMessageResponse body);
    
}
