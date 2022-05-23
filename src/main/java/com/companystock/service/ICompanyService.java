package com.companystock.service;


import com.companystock.companyexception.CompanyAlreadyExistsException;
import com.companystock.model.CompanyRegisterModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Component
@Service
public interface ICompanyService {

    public CompanyRegisterModel getCompanyById(long companyCode);

    public CompanyRegisterModel deleteCompany(long companyCode);

    public CompanyRegisterModel updateCompany(CompanyRegisterModel cmp);

    public List<CompanyRegisterModel> loadAllCompanyDetails();

    public CompanyRegisterModel saveCompany(CompanyRegisterModel cmp) throws CompanyAlreadyExistsException;

}
