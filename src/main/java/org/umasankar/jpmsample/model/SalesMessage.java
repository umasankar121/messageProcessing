package org.umasankar.jpmsample.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Umasankar on 7/23/17.
 */
@XmlRootElement(name = "Sales")
public class SalesMessage {
    private String product;
    private int quantity;
    private double price;

    public SalesMessage() {}

    public String getProduct() {
        return product;
    }
    @XmlElement
    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }
    @XmlElement
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }
    @XmlElement
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SalesMessage{");
        sb.append("product='").append(product).append('\'');
        sb.append(", quantity=").append(quantity);
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }

	public boolean equals(String product) {
		// TODO Auto-generated method stub
		return this.product.equals(product);
	}
}
