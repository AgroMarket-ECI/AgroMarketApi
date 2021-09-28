package org.agro.market.demo.service;

import org.agro.market.demo.controller.payment.dto.PaymentDto;
import org.agro.market.demo.repository.document.Payment;

public interface PaymentService {
    Payment generatePayment(PaymentDto paymentDto);
}
