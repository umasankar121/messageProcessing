package org.umasankar.jpmsample.model;

/**
 * Created by Umasankar on 7/22/17.
 */
public class SalesMessageModel {

    private String product;
    /**
     * price of the product in INR
     * e.g. 10p = 0.1
     *      1 Ruppee 25P = 1.25
     */
    private double price;
    /**
     * Amount of product.
     * default 1
     */
    private int salesNumber=1;
    /**
     * New = 1
     * Update = 2
     * Adjustment = 3
     */
    private int messageType;

    private String adjType;
    private double adjAmount;

    public SalesMessageModel() {

    }
    public SalesMessageModel(String product, double price) {
        this(product, 1, price);
    }

    public SalesMessageModel(String product, int salesCount, double price) {
        this.product = product;
        this.salesNumber = salesCount;
        this.price = price;
        this.messageType = salesCount == 1 ? 1 : 2;
    }

    public SalesMessageModel(String product, String adjType, double adjAmount) {
        this.product = product;
        this.adjType = adjType;
        this.adjAmount = adjAmount;
        this.messageType = 3;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSalesNumber() {
        return salesNumber;
    }

    public void setSalesNumber(int salesNumber) {
        this.salesNumber = salesNumber;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public String getAdjType() {
        return adjType;
    }

    public void setAdjType(String adjType) {
        this.adjType = adjType;
    }

    public double getAdjAmount() {
        return adjAmount;
    }

    public void setAdjAmount(double adjAmount) {
        this.adjAmount = adjAmount;
    }
}
