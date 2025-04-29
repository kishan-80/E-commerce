package com.webApp.Ecommerce.dto;

public class OrderItemsDTO {

    private int productQuantity;

    private String productName;

    private  double productPrice;

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public OrderItemsDTO(int productQuantity, String productName, double productPrice) {
        this.productQuantity = productQuantity;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public OrderItemsDTO(){}

    @Override
    public String toString() {
        return "OrderItemsDTO{" +
                "productQuantity=" + productQuantity +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}
