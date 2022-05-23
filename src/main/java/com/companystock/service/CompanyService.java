package com.companystock.service;

import com.companystock.companyexception.CompanyAlreadyExistsException;

import com.companystock.companyexception.NoSuchCompanyExistsException;
import com.companystock.model.CompanyRegisterModel;

import com.companystock.repository.ICompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService implements ICompanyService {

    @Autowired
    ICompanyRepository companyRepo;
    @Override
    public CompanyRegisterModel saveCompany(CompanyRegisterModel cmp)
    {
        CompanyRegisterModel existingCompany = companyRepo.findById(cmp.getCompanyCode())
                .orElse(null);
        if (existingCompany == null) {

            return companyRepo.save(cmp);
        }
        else
            throw new CompanyAlreadyExistsException(
                  "Company already exits!!");
    }

    public CompanyRegisterModel getCompanyById(long companyCode) {

        CompanyRegisterModel existingCompany
                = companyRepo.findById(companyCode)
                .orElse(null);
        if (existingCompany == null)
            throw new NoSuchCompanyExistsException(
                    "No Such Company exists!!");
        else
        return companyRepo.findById(companyCode).get();
    }

    public CompanyRegisterModel deleteCompany(long companyCode) {
        Optional<CompanyRegisterModel> company = companyRepo.findById(companyCode);
        if (company.isEmpty()) {
            return null;
        }
            companyRepo.deleteById(companyCode);
         return company.get();
    }

    public CompanyRegisterModel updateCompany(CompanyRegisterModel cmp) {

        CompanyRegisterModel existingCompany
                = companyRepo.findById(cmp.getCompanyCode())
                .orElse(null);
        if (existingCompany == null)
            throw new NoSuchCompanyExistsException(
                    "No Such Company exists to update!!");
        else
            existingCompany.setCompanyName(cmp.getCompanyName());
        existingCompany.setCompanyCeo(cmp.getCompanyCeo());
        existingCompany.setCompanyEmail(cmp.getCompanyEmail());
        existingCompany.setWebsite(cmp.getWebsite());
        existingCompany.setTurnover(cmp.getTurnover());
        existingCompany.setStockExchange(cmp.getStockExchange());
         return companyRepo.save(existingCompany);
    }
    public List<CompanyRegisterModel> loadAllCompanyDetails() {

        return companyRepo.findAll();

    }
}
