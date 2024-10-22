package org.noctisdev.sciallhexvsg.payments.application;

import org.noctisdev.sciallhexvsg.payments.application.dto.request.PaymentProfileRequest;
import org.noctisdev.sciallhexvsg.payments.domain.models.PaymentProfile;
import org.noctisdev.sciallhexvsg.shared.BaseResponse;

import java.util.UUID;

public interface IPaymentProfileService {
    BaseResponse createPaymentProfile(PaymentProfileRequest request);
    PaymentProfile findByUuid(UUID uuid);
}
