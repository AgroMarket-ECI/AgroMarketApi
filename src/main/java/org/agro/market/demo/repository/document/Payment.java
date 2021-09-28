package org.agro.market.demo.repository.document;

import org.agro.market.demo.controller.payment.dto.PaymentDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Payment {
    @Id
    String idOrder;
    double totalPayment;
    Date createdAt;

    public Payment(String idOrder, double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public Payment(PaymentDto paymentDto) {
        totalPayment = paymentDto.getTotalPayment();
        createdAt = new Date();
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
