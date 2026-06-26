
package com.br.church.memberManager.domain.model;

import com.br.church.memberManager.domain.enums.EducationEnum;
import com.br.church.memberManager.domain.enums.MaritalStatusEnum;
import com.br.church.memberManager.domain.enums.SexyEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Person {
    private UUID id;
    private String name;
    private String nickName;
    private LocalDate birthDate;
    private String naturalness;
    private String originCity;
    private SexyEnum sexyEnum;
    private MaritalStatusEnum maritalStatusEnum;
    private String cpf;
    private String rg;
    private String orgaoExpeditor;
    private String professional;
    private String companyWork;
    private EducationEnum educationEnum;
    private boolean member;
    private LocalDateTime deletedAt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getNaturalness() {
        return naturalness;
    }

    public void setNaturalness(String naturalness) {
        this.naturalness = naturalness;
    }

    public String getOriginCity() {
        return originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

    public SexyEnum getSexyEnum() {
        return sexyEnum;
    }

    public void setSexyEnum(SexyEnum sexyEnum) {
        this.sexyEnum = sexyEnum;
    }

    public MaritalStatusEnum getMaritalStatusEnum() {
        return maritalStatusEnum;
    }

    public void setMaritalStatus(MaritalStatusEnum maritalStatusEnum) {
        this.maritalStatusEnum = maritalStatusEnum;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getOrgaoExpeditor() {
        return orgaoExpeditor;
    }

    public void setOrgaoExpeditor(String orgaoExpeditor) {
        this.orgaoExpeditor = orgaoExpeditor;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getCompanyWork() {
        return companyWork;
    }

    public void setCompanyWork(String companyWork) {
        this.companyWork = companyWork;
    }

    public EducationEnum getEducationEnum() {
        return educationEnum;
    }

    public void setEducationEnum(EducationEnum educationEnum) {
        this.educationEnum = educationEnum;
    }

    public void setMaritalStatusEnum(MaritalStatusEnum maritalStatusEnum) {
        this.maritalStatusEnum = maritalStatusEnum;
    }

    public boolean isMember() {
        return member;
    }

    public void setMember(boolean member) {
        this.member = member;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
