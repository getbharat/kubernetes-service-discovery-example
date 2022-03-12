package com.ecom.order.model;

public class Order {
    private String orderId;
    private String orderDescription;
    private String orderDate;
    private String shippingAddress;
    private String billingAddress;

    public Order(String orderId, String orderDescription, String orderDate, String shippingAddress, String billingAddress) {
        this.orderId = orderId;
        this.orderDescription = orderDescription;
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Order(String orderId, String orderDescription, String orderDate) {
        this.orderId = orderId;
        this.orderDescription = orderDescription;
        this.orderDate = orderDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
