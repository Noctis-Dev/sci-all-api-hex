package org.noctisdev.sciallhexvsg.payments.application.impl;

import org.noctisdev.sciallhexvsg.payments.application.IPaymentProfileService;
import org.noctisdev.sciallhexvsg.payments.application.dto.request.PaymentProfileRequest;
import org.noctisdev.sciallhexvsg.payments.application.dto.response.PaymentProfileResponse;
import org.noctisdev.sciallhexvsg.payments.domain.models.PaymentProfile;
import org.noctisdev.sciallhexvsg.payments.domain.repository.IPaymentProfileRepository;
import org.noctisdev.sciallhexvsg.shared.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentProfileServiceImpl implements IPaymentProfileService {

    @Autowired
    private IPaymentProfileRepository repository;

    @Override
    public BaseResponse createPaymentProfile(PaymentProfileRequest request) {
        PaymentProfile paymentProfile = new PaymentProfile();
        paymentProfile.setPaymentProfileUuid(UUID.randomUUID());
        paymentProfile.setProfileName(request.profileName());
        paymentProfile.setAccountEmail(request.accountEmail());

        repository.save(paymentProfile);

        PaymentProfileResponse response = new PaymentProfileResponse(
            paymentProfile.getPaymentProfileUuid(),
            paymentProfile.getProfileName(),
            paymentProfile.getAccountEmail()
        );

        return BaseResponse.builder()
            .data(response)
            .message("Payment profile created successfully")
            .success(Boolean.TRUE)
            .status(200).build();
    }

    @Override
    public PaymentProfile findByUuid(UUID uuid) {
        return repository.findByUuid(uuid);
    }
}
