package com.reply.challenge.model;

import jakarta.persistence.*;

@Entity
@Table(name = "company_account")
@DiscriminatorValue("company")
public class CompanyAccount extends Customer{

    private String taxNumber;

    @Enumerated(EnumType.STRING)
    private CompanyForm companyForm;

    public CompanyAccount() {
        super();
    }
    public CompanyAccount(String taxNumber, CompanyForm companyForm) {
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

    public CompanyForm getCompanyForm() {
        return companyForm;
    }

    public void setCompanyForm(CompanyForm companyForm) {
        this.companyForm = companyForm;
    }
}
