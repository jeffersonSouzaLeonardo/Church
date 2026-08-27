package com.br.church.memberManager.domain.enums;

public enum MaritalStatusEnum {
    SOLTEIRO("Solteiro"),
    CASADO("Casado"),
    VIUVO("Viuvo"),
    DIVORCIADO("Divorciado");

    private String description;

    MaritalStatusEnum(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public static MaritalStatusEnum fromString(String value) {
        if (value == null || value.isBlank()) {
            return null;
        }
        for (MaritalStatusEnum status : values()) {
            if (status.name().equalsIgnoreCase(value.trim())
                    || status.description.equalsIgnoreCase(value.trim())) {
                return status;
            }
        }
        throw new IllegalArgumentException("Valor inválido para estado civil: " + value);
    }

}
