package com.reply.challenge.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("company")
public class CompanyAccount extends Customer{

    private String taxNumber;

    private String companyForm;

    public CompanyAccount() {
        super();
    }
    public CompanyAccount(String taxNumber, String companyForm) {
        super();
        this.taxNumber = taxNumber;
        this.companyForm = companyForm;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getCompanyForm() {
        return companyForm;
    }

    public void setCompanyForm(String companyForm) {
        this.companyForm = companyForm;
    }
}
