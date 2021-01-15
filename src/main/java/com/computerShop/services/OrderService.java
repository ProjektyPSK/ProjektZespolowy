package com.computerShop.services;

import com.computerShop.Entity.Order;
import com.computerShop.Entity.OrderItem;
import com.computerShop.Entity.Users;
import com.computerShop.repository.OrderItemRepository;
import com.computerShop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class OrderService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    UsersService usersService;


    public void addOrderItem(OrderItem orderItem, Principal principal){
        orderItemRepository.save(orderItem);
    }

    public void addOrder(Order order, Principal principal){
        Users currentUser = usersService.getCurrentUser(principal.getName());

        order.setUser(currentUser);
        orderRepository.save(order);
    }
}
