package com.companystock.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="CS_Stock")
public class StockModel {

    @Id
    @Column(name="cs_s_id",nullable = false,length=5)
    private long id;

    @Column(name="cs_s_stockName",nullable = false,length=20)
    private String stockName;

    @Column(name="cs_s_stockPrice",nullable = false,length=5)
    private long stockPrice;

    @Column(name="cs_c_starDate",nullable = false,length=10)
    private LocalDate startDate;

    @Column(name="cs_c_endDate",nullable = false,length=10)
    private LocalDate endDate;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "cs_c_code", referencedColumnName = "cs_c_code",nullable=false)
    @JsonBackReference
    private CompanyRegisterModel  company;
}
