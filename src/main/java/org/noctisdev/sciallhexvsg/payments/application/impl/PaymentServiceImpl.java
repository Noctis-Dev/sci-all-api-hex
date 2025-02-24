package org.noctisdev.sciallhexvsg.payments.application.impl;

import org.noctisdev.sciallhexvsg.payments.application.IPaymentProfileService;
import org.noctisdev.sciallhexvsg.payments.application.IPaymentService;
import org.noctisdev.sciallhexvsg.payments.application.dto.request.PaymentRequest;
import org.noctisdev.sciallhexvsg.payments.application.dto.response.PaymentResponse;
import org.noctisdev.sciallhexvsg.payments.domain.external.IPayments;
import org.noctisdev.sciallhexvsg.payments.domain.models.Payment;
import org.noctisdev.sciallhexvsg.payments.domain.models.PaymentProfile;
import org.noctisdev.sciallhexvsg.payments.domain.repository.IPaymentRepository;
import org.noctisdev.sciallhexvsg.shared.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements IPaymentService {

    @Autowired
    private IPayments payments;

    @Autowired
    private IPaymentProfileService paymentProfileService;

    @Autowired
    private IPaymentRepository repository;

    @Override
    public BaseResponse generatePayment(PaymentRequest request) {
        PaymentProfile profile = paymentProfileService.findByUuid(request.paymentProfileId());

        Payment payment = new Payment();
        payment.setPaymentUuid(UUID.randomUUID());
        payment.setAmount(request.amount());
        payment.setPaymentProfile(profile);

        String url = payments.generateDonationPaymentUrl("another", payment.getAmount());

        PaymentResponse response = new PaymentResponse(
            url,
            LocalDate.now()
        );

        return BaseResponse.builder()
            .data(response)
            .message("Payment generated successfully")
            .success(Boolean.TRUE)
            .httpStatus(HttpStatus.OK)
            .status(200).build();
    }
}
