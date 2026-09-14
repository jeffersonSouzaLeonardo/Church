package com.br.church.entity;

import com.br.church.model.enums.EducationEnum;
import com.br.church.model.enums.MaritalStatusEnum;
import com.br.church.model.enums.ReceptionMethodEnum;
import com.br.church.model.enums.SexyEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="persons")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório.")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
    private String name;

    private String nickName;
    private LocalDate birthDate;
    private String naturalness;
    private String originCity;

    @Enumerated(EnumType.STRING)
    private SexyEnum sexyEnum;

    @Enumerated(EnumType.STRING)
    private MaritalStatusEnum maritalStatusEnum;
    private String cpf;
    private String rg;
    private String orgaoExpeditor;
    private String professional;
    private String companyWork;
    @Enumerated(EnumType.STRING)
    private EducationEnum educationEnum;
    private boolean member;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @CreationTimestamp
    private LocalDateTime createdAt;
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
    @Enumerated(EnumType.STRING)
    private ReceptionMethodEnum receptionMethod;
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

    public SexyEnum getSexyEnum() {
        return sexyEnum;
    }

    public void setSexyEnum(SexyEnum sexyEnum) {
        this.sexyEnum = sexyEnum;
    }

    public MaritalStatusEnum getMaritalStatusEnum() {
        return maritalStatusEnum;
    }

    public void setMaritalStatusEnum(MaritalStatusEnum maritalStatusEnum) {
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

    public boolean isMember() {
        return member;
    }

    public void setMember(boolean member) {
        this.member = member;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
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

    public ReceptionMethodEnum getReceptionMethod() {
        return receptionMethod;
    }

    public void setReceptionMethod(ReceptionMethodEnum receptionMethod) {
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
