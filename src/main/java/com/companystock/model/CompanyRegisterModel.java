package com.companystock.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="CS_Company")
public class CompanyRegisterModel {
    @Id
    @Column(name="cs_c_code",nullable = false, length = 5)
    private long companyCode;

    @Column(name="cs_c_name",nullable = false,length=15)
    private String companyName;

    @Column(name="cs_c_email",nullable = false,length=20)
    private String companyEmail;

    @Column(name="cs_c_ceo",nullable = false,length=20)
    private String companyCeo;

    @Column(name="cs_c_turnover",nullable = false,length=20)
    private String turnover;

    @Column(name="cs_c_website",nullable = false,length=20)
    private String website;

    @Column(name="cs_c_stockExchange ",nullable = false,length=20)
    private String stockExchange;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("company")
    private List<StockModel> stockList=new ArrayList<>();
}

