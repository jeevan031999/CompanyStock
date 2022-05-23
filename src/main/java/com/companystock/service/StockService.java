package com.companystock.service;

import com.companystock.companyexception.NoSuchCompanyExistsException;
import com.companystock.model.CompanyRegisterModel;
import com.companystock.model.StockModel;

import com.companystock.stockexception.StockAlreadyExistsException;
import com.companystock.repository.IStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService implements IStockService{

   @Autowired
   IStockRepository stockRepository;

    public StockModel getStockByCompanyCode(long companyCode)
    {
        StockModel existingStock
                = stockRepository.findById(companyCode)
                .orElse(null);
        if (existingStock == null)
            throw new NoSuchCompanyExistsException(
                    "No Such Stock exists!!");
        else
        return stockRepository.findById(companyCode).get();
    }
public StockModel saveStock(StockModel stock)
 {
     StockModel existingStock = stockRepository.findById(stock.getId()).orElse(null);
     if (existingStock == null) {

         return stockRepository.save(stock);
     }
     else
         throw new StockAlreadyExistsException(
                 "Stock already exits!!");
     }

//   public StockModel updateStock(StockModel cmp)
//    {
//        return stockRepository.save(cmp);
//    }
    public StockModel updateStock(StockModel cmp) {

        StockModel existingStock = stockRepository.findById(cmp.getId())
                .orElse(null);
        if (existingStock == null)
            throw new NoSuchCompanyExistsException(
                    "No Such Company exists to update!!");
        else
            existingStock.setStockName(cmp.getStockName());
        existingStock.setStockPrice(cmp.getStockPrice());
        existingStock.setStartDate(cmp.getStartDate());
        existingStock.setEndDate(cmp.getEndDate());
        return stockRepository.save(existingStock);
    }

}

