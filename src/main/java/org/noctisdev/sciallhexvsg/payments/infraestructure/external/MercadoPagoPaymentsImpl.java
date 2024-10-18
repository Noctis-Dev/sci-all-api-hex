package org.noctisdev.sciallhexvsg.payments.infraestructure.external;

import org.noctisdev.sciallhexvsg.payments.domain.external.IPayments;
import org.springframework.stereotype.Component;

@Component
public class MercadoPagoPaymentsImpl implements IPayments {

    @Override
    public String generateDonationPaymentUrl(String to, Float amount) {
        return "";
    }

}
