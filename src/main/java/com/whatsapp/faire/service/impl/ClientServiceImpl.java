package com.whatsapp.faire.service.impl;

import com.whatsapp.faire.model.Client;
import com.whatsapp.faire.model.Order;
import com.whatsapp.faire.service.ClientService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author eder
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Override
    public Map<Client, List<Order>> getGroupedOrdersByClient(List<Order> newOrders) {
        
        // TODO here we have to filter the orders by client.
        // I dont have an idea how to perform this, so lets mock a little bit.
        final Client client = new Client();
        
        client.setName("Jonny Walker");
        client.setMobileNumber("555199999999");
        
        final Map<Client, List<Order>> clientOrdersMap = new HashMap();
        
        clientOrdersMap.put(client, newOrders);
        
        return clientOrdersMap;
        
    }
    
}
