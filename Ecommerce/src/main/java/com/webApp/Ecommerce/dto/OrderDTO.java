package com.webApp.Ecommerce.dto;

import java.util.Date;
import java.util.List;

public class OrderDTO {

    private Long id;

    private String userName;

    private String userEmail;

    private double totalAmount;

    private String status;

    private Date orderDate;

    protected List<OrderItemsDTO> orderItemsDTOList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderItemsDTO> getOrderItemsDTOList() {
        return orderItemsDTOList;
    }

    public void setOrderItemsDTOList(List<OrderItemsDTO> orderItemsDTOList) {
        this.orderItemsDTOList = orderItemsDTOList;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", totalAmount=" + totalAmount +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                ", orderItemsDTOList=" + orderItemsDTOList +
                '}';
    }

    public OrderDTO(Long id, String userName, String userEmail, double totalAmount, String status, Date orderDate, List<OrderItemsDTO> orderItemsDTOList) {
        this.id = id;
        this.userName = userName;
        this.userEmail = userEmail;
        this.totalAmount = totalAmount;
        this.status = status;
        this.orderDate = orderDate;
        this.orderItemsDTOList = orderItemsDTOList;
    }
    public OrderDTO(){

    }
}
