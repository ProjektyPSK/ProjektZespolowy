package com.computerShop.controllers;

import com.computerShop.Entity.Order;
import com.computerShop.Entity.OrderItem;
import com.computerShop.Utils.View;
import com.computerShop.services.OrderService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @JsonView(View.OrderItem.class)
    @PostMapping(value = "/orderItem", produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void addOrderItem(@ModelAttribute OrderItem orderItem, Principal principal) {
        orderService.addOrderItem(orderItem, principal);
    }

    @JsonView(View.Order.class)
    @PostMapping(value = "/order", produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public Long addOrder(@ModelAttribute Order order, Principal principal) {
        return orderService.addOrder(order, principal);
    }

}
