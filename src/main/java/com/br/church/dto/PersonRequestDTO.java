package com.br.church.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PersonRequestDTO {
    private Long id;
    private String name;
    private String nickName;
    private LocalDate birthDate;
    private String naturalness;
    private String originCity;
    private String sexy;
    private String maritalStatus;
    private String cpf;
    private String rg;
    private String orgaoExpeditor;
    private String professional;
    private String companyWork;
    private String education;
    private boolean member;
    private LocalDateTime deletedAt;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String cep;
    private LocalDateTime conversionDate;
    private String conversionPlace;
    private String baptismPlace;
    private String baptizedBy;
    private boolean discipleship;
    private boolean bibleSchool;
    private String lastChurchName;
    private String denomination;
    private String churchCity;
    private Integer membershipYears;
    private String receptionMethod;
    private LocalDateTime receptionDate;
    private String membersBookNumber;
    private String specialNeeds;
    private LocalDateTime lastPastoralVisit;
    private boolean cellGroup;
    private String cellGroupName;
    private String cellGroupLeaderName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getSexy() {
        return sexy;
    }

    public void setSexy(String sexy) {
        this.sexy = sexy;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
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

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public boolean getMember() {
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public LocalDateTime getConversionDate() {
        return conversionDate;
    }

    public void setConversionDate(LocalDateTime conversionDate) {
        this.conversionDate = conversionDate;
    }

    public String getConversionPlace() {
        return conversionPlace;
    }

    public void setConversionPlace(String conversionPlace) {
        this.conversionPlace = conversionPlace;
    }

    public String getBaptismPlace() {
        return baptismPlace;
    }

    public void setBaptismPlace(String baptismPlace) {
        this.baptismPlace = baptismPlace;
    }

    public String getBaptizedBy() {
        return baptizedBy;
    }

    public void setBaptizedBy(String baptizedBy) {
        this.baptizedBy = baptizedBy;
    }

    public boolean isDiscipleship() {
        return discipleship;
    }

    public void setDiscipleship(boolean discipleship) {
        this.discipleship = discipleship;
    }

    public boolean isBibleSchool() {
        return bibleSchool;
    }

    public void setBibleSchool(boolean bibleSchool) {
        this.bibleSchool = bibleSchool;
    }

    public String getLastChurchName() {
        return lastChurchName;
    }

    public void setLastChurchName(String lastChurchName) {
        this.lastChurchName = lastChurchName;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public String getChurchCity() {
        return churchCity;
    }

    public void setChurchCity(String churchCity) {
        this.churchCity = churchCity;
    }

    public Integer getMembershipYears() {
        return membershipYears;
    }

    public void setMembershipYears(Integer membershipYears) {
        this.membershipYears = membershipYears;
    }

    public String getReceptionMethod() {
        return receptionMethod;
    }

    public void setReceptionMethod(String receptionMethod) {
        this.receptionMethod = receptionMethod;
    }

    public LocalDateTime getReceptionDate() {
        return receptionDate;
    }

    public void setReceptionDate(LocalDateTime receptionDate) {
        this.receptionDate = receptionDate;
    }

    public String getMembersBookNumber() {
        return membersBookNumber;
    }

    public void setMembersBookNumber(String membersBookNumber) {
        this.membersBookNumber = membersBookNumber;
    }

    public String getSpecialNeeds() {
        return specialNeeds;
    }

    public void setSpecialNeeds(String specialNeeds) {
        this.specialNeeds = specialNeeds;
    }

    public LocalDateTime getLastPastoralVisit() {
        return lastPastoralVisit;
    }

    public void setLastPastoralVisit(LocalDateTime lastPastoralVisit) {
        this.lastPastoralVisit = lastPastoralVisit;
    }

    public boolean isCellGroup() {
        return cellGroup;
    }

    public void setCellGroup(boolean cellGroup) {
        this.cellGroup = cellGroup;
    }

    public String getCellGroupName() {
        return cellGroupName;
    }

    public void setCellGroupName(String cellGroupName) {
        this.cellGroupName = cellGroupName;
    }

    public String getCellGroupLeaderName() {
        return cellGroupLeaderName;
    }

    public void setCellGroupLeaderName(String cellGroupLeaderName) {
        this.cellGroupLeaderName = cellGroupLeaderName;
    }
}
