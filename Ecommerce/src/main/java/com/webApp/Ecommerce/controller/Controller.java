package com.webApp.Ecommerce.controller;

import com.webApp.Ecommerce.dto.OrderDTO;
import com.webApp.Ecommerce.entity.OrderRequest;
import com.webApp.Ecommerce.entity.Orders;
import com.webApp.Ecommerce.entity.User;
import com.webApp.Ecommerce.service.OrderService;
import com.webApp.Ecommerce.service.UserService;
import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class Controller {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @PostMapping("/user/register")
    public User registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }

    @PostMapping("/user/login")
    public User loginUser(@RequestParam String email, @RequestParam String password){
        return userService.loginUser(email,password);
    }

    @GetMapping("/user/getAllUser")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @PostMapping("order/placeOrder/{userId}")
    public OrderDTO placeOrder(@PathVariable Long userId , @RequestBody OrderRequest orderRequest){
        return orderService.placeOrder(userId,orderRequest.getProductQuantities(),orderRequest.getTotalAmount());
    }

    @GetMapping("/order/getOrdersByUserId/{userId}")
    public List<OrderDTO> getOrdersByUserId(@PathVariable Long userId){
        return orderService.getOrdersByUserId(userId);
    }


}
