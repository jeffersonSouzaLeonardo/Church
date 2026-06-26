package com.br.church.memberManager.domain.enums;

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
}