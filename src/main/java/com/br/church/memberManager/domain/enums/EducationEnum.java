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

    public static EducationEnum fromString(String value) {
        if (value == null || value.isBlank()) {
            return null;
        }
        for (EducationEnum education : values()) {
            if (education.name().equalsIgnoreCase(value.trim())
                    || education.description.equalsIgnoreCase(value.trim())) {
                return education;
            }
        }
        throw new IllegalArgumentException("Valor inválido para escolaridade: " + value);
    }
}
