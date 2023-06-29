package com.reply.challenge.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


import java.util.Date;

@Entity
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
