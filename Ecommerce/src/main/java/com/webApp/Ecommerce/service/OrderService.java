package com.webApp.Ecommerce.service;

import com.webApp.Ecommerce.dto.OrderDTO;
import com.webApp.Ecommerce.dto.OrderItemsDTO;
import com.webApp.Ecommerce.entity.*;
import com.webApp.Ecommerce.repository.OrdersRepo;
import com.webApp.Ecommerce.repository.ProductRepo;
import com.webApp.Ecommerce.repository.UserRepo;
import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;
import java.util.stream.Collectors;

public class OrderService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private OrdersRepo ordersRepo;

    @Autowired
    private ProductRepo productRepo;

    public OrderDTO placeOrder(Long userId, Map<Long, Integer> productQuantities, double totalAmount) {
        User user = userRepo.findById(userId)
                .orElseThrow(()-> new RuntimeException("user not found"));

        Orders orders = new Orders();
        orders.setUser(user);
        orders.setStatus("Pending");
        orders.setOrderDate(new Date());
        orders.setTotalAmount(totalAmount);

        List<OrderItems> orderItemslist = new ArrayList<>();
        List<OrderItemsDTO> orderItemsDTOList = new ArrayList<>();

        for(Map.Entry<Long,Integer> entry : productQuantities.entrySet()){
            Product product = productRepo.findById(entry.getKey())
                    .orElseThrow(()-> new RuntimeException("Product Not found"));
            OrderItems orderItems = new OrderItems();
            orderItems.setOrders(orders);
            orderItems.setProduct(product);
            orderItems.setQuantity(entry.getValue());
            orderItemslist.add(orderItems);

            orderItemsDTOList.add(new OrderItemsDTO(entry.getValue(),product.getName(), product.getPrice()));
        }
        orders.setOrderItems(orderItemslist);
        Orders saveOrder = ordersRepo.save(orders);
        return new OrderDTO(saveOrder.getId(),user.getName(),user.getEmail(),saveOrder.getTotalAmount(),saveOrder.getStatus()
        ,saveOrder.getOrderDate(),orderItemsDTOList);

    }

    public List<OrderDTO> getOrdersByUserId(Long userId) {
        Optional<User> userOp = userRepo.findById(userId);
        if(userOp.isEmpty()) throw new RuntimeException("user not found");
        User user = userOp.get();
        List<Orders> ordersList = ordersRepo.findAllByUser(user);
        return ordersList.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private OrderDTO convertToDTO(Orders orders) {
        List<OrderItemsDTO> orderItems = orders.getOrderItems().stream()
                .map(item -> new OrderItemsDTO(
                        item.getQuantity(),
                        item.getProduct().getName(),
                        item.getProduct().getPrice())).collect(Collectors.toList());
        return new OrderDTO(orders.getId(),
                orders.getUser()!= null? orders.getUser().getName() : "Unknown",
                orders.getUser()!= null? orders.getUser().getEmail() : "Unknown",
                orders.getTotalAmount(),orders.getStatus(),
                orders.getOrderDate(),orderItems
        );

    }
}
