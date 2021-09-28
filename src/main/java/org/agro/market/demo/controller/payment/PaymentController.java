package org.agro.market.demo.controller.payment;

import org.agro.market.demo.controller.payment.dto.PaymentDto;
import org.agro.market.demo.repository.document.Payment;
import org.agro.market.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/v1/payment" )
public class PaymentController{
    private final PaymentService paymentService;

    public PaymentController( @Autowired PaymentService paymentService ){
        this.paymentService = paymentService;
    }

    @PostMapping()
    public Payment generatePayment(@RequestBody PaymentDto paymentDto){
        return paymentService.generatePayment(paymentDto);
    }

}
