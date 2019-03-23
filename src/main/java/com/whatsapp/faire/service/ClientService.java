/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.whatsapp.faire.service;

import com.whatsapp.faire.model.Client;
import com.whatsapp.faire.model.Order;
import java.util.List;
import java.util.Map;

/**
 *
 * @author eder
 */
public interface ClientService {

    public Map<Client, List<Order>> getGroupedOrdersByClient(List<Order> newOrders);
    
}
