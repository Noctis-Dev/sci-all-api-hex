package org.noctisdev.sciallhexvsg.payments.infraestructure.mapper.impl;

import org.noctisdev.sciallhexvsg.payments.domain.models.PaymentProfile;
import org.noctisdev.sciallhexvsg.payments.infraestructure.entities.PaymentProfileEntity;
import org.noctisdev.sciallhexvsg.payments.infraestructure.mapper.IPaymentProfileMapper;
import org.springframework.stereotype.Component;

@Component
public class PaymentProfileMapperImpl implements IPaymentProfileMapper {
    @Override
    public PaymentProfile toDomain(PaymentProfileEntity entity) {
        PaymentProfile paymentProfile = new PaymentProfile();

        paymentProfile.setId(entity.getId());
        paymentProfile.setPaymentProfileUuid(entity.getPaymentProfileUuid());
        paymentProfile.setProfileName(entity.getProfileName());
        paymentProfile.setAccountEmail(entity.getAccountEmail());

        return paymentProfile;
    }

    @Override
    public PaymentProfileEntity toEntity(PaymentProfile domain) {
        PaymentProfileEntity entity = new PaymentProfileEntity();

        entity.setId(domain.getId());
        entity.setPaymentProfileUuid(domain.getPaymentProfileUuid());
        entity.setProfileName(domain.getProfileName());
        entity.setAccountEmail(domain.getAccountEmail());

        return entity;
    }
}
