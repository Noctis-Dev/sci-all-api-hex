package org.noctisdev.sciallhexvsg.notifications.domain.external;

public interface INotify {

    void sendMessage(String message, String phoneNumber);

}
