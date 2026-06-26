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

}
