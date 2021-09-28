package org.agro.market.demo.service.impl;

import org.agro.market.demo.controller.payment.dto.PaymentDto;
import org.agro.market.demo.repository.PaymentRepository;
import org.agro.market.demo.repository.document.Payment;
import org.agro.market.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceMongoDB implements PaymentService{
    private final PaymentRepository paymentRepository;

    public PaymentServiceMongoDB (@Autowired PaymentRepository paymentRepository ){
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment generatePayment(PaymentDto paymentDto) {
        return paymentRepository.save(new Payment(paymentDto));
    }
}
