package com.br.church.model.enums;

public enum ReceptionMethodEnum {
    BAPTISM("Batismo"),
    PROFESSION_OF_FAITH("Profissão de Fé"),
    RECONCILIATION("Reconciliação"),
    TRANSFER("Transferência"),
    JURISDICTION("Jurisdição");

    private String description;

    ReceptionMethodEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static ReceptionMethodEnum fromString(String value) {
        if (value == null || value.isBlank()) {
            return null;
        }
        for (ReceptionMethodEnum method : values()) {
            if (method.name().equalsIgnoreCase(value.trim())
                    || method.description.equalsIgnoreCase(value.trim())) {
                return method;
            }
        }
        throw new IllegalArgumentException("Valor inválido para forma de recebimento: " + value);
    }
}
