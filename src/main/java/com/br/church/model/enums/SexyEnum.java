package com.br.church.model.enums;

public enum SexyEnum {
    MASCULINO("Masculino"),
    FEMININO("Feminino");

    private final String description;

    SexyEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static SexyEnum fromString(String value) {
        if (value == null || value.isBlank()) {
            return null;
        }
        for (SexyEnum sexy : values()) {
            if (sexy.name().equalsIgnoreCase(value.trim())
                    || sexy.description.equalsIgnoreCase(value.trim())) {
                return sexy;
            }
        }
        throw new IllegalArgumentException("Valor inválido para sexo: " + value);
    }
}