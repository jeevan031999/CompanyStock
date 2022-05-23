package com.companystock.repository;

import com.companystock.model.CompanyRegisterModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompanyRepository extends JpaRepository<CompanyRegisterModel,Long> {

}