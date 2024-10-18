package org.noctisdev.sciallhexvsg.notifications.infraestructure.external;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.noctisdev.sciallhexvsg.notifications.domain.INotify;
import org.noctisdev.sciallhexvsg.notifications.infraestructure.configurations.TwilioConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TwilioNotifyImpl implements INotify {

    @Autowired
    private TwilioConfig config;

    @Override
    public void sendMessage(String to, String message) {
        Twilio.init(config.getAccountSid(), config.getAuthToken());

        Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:"+to),
                new com.twilio.type.PhoneNumber("whatsapp:"+config.getPhoneNumber()),
                message
        ).create();
    }
}
