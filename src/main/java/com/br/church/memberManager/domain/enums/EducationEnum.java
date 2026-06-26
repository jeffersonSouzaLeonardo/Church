package com.br.church.memberManager.domain.enums;

public enum EducationEnum {
    FUNDAMENTAL("Fundamental"),
    MEDIO("Medio"),
    SUPERIOR("Superior"),
    POS_GRADUACAO("Pos Graduação");

    private String description;

    EducationEnum(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
