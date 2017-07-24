package org.umasankar.jpmsample.model;

import java.util.Date;

/**
 * Created by Umasankar on 7/23/17.
 */
public class SalesModel {

    private String product;
    private int quantity;
    private double price;
    //Fake property
    private Date tradeDate = new Date();

    public SalesModel(){}

    public double getAmount() {
        return quantity * price;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }
}
