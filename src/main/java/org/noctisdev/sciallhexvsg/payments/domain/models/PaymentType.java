package org.noctisdev.sciallhexvsg.payments.domain.models;

public enum PaymentType {
    DONATION("DONATION"),
    SUBSCRIPTION("SUBSCRIPTION");

    private final String value;

    PaymentType(String value) {
        this.value = value;
    }

    public static PaymentType fromString(String value) {
        for (PaymentType type : PaymentType.values()) {
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }

        throw new RuntimeException("INVALID VALUE FOR ENUM");
    }
}
