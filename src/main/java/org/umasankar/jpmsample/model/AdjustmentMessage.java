package org.umasankar.jpmsample.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Umasankar on 7/23/17.
 */
@XmlRootElement(name = "Adjustment")
public class AdjustmentMessage {

    private String product;
    private double updateAmount;
    private String operation;

    public AdjustmentMessage(){}

    public String getProduct() {
        return product;
    }
    @XmlElement
    public void setProduct(String product) {
        this.product = product;
    }

    public double getUpdateAmount() {
        return updateAmount;
    }
    @XmlElement(name = "amount")
    public void setUpdateAmount(double updateAmount) {
        this.updateAmount = updateAmount;
    }

    public String getOperation() {
        return operation;
    }
    @XmlElement
    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AdjustmentMessage{");
        sb.append("product='").append(product).append('\'');
        sb.append(", updateAmount=").append(updateAmount);
        sb.append(", operation='").append(operation).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
