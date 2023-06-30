package com.reply.challenge.model;

import jakarta.persistence.*;


import java.util.Date;

@Entity
@Table(name = "individual_account")
@DiscriminatorValue("individual")
public class IndividualAccount extends Customer{

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    private String identifierTag;

    public IndividualAccount() {
        super();
    }

    public IndividualAccount(Date birthDate, String identifierTag) {
        super();
        this.birthDate = birthDate;
        this.identifierTag = identifierTag;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getIdentifierTag() {
        return identifierTag;
    }

    public void setIdentifierTag(String identifierTag) {
        this.identifierTag = identifierTag;
    }
}
