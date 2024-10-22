package org.noctisdev.sciallhexvsg.payments.infraestructure.controllers;

import org.noctisdev.sciallhexvsg.payments.application.IPaymentService;
import org.noctisdev.sciallhexvsg.payments.application.dto.request.PaymentRequest;
import org.noctisdev.sciallhexvsg.shared.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/donate")
public class CreateDonationController {

    @Autowired
    private IPaymentService paymentService;

    @PostMapping
    public ResponseEntity<BaseResponse> createDonation(@RequestBody PaymentRequest request) {
        return paymentService.generatePayment(request).apply();
    }

}
