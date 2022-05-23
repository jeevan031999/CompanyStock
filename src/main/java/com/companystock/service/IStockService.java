package com.companystock.service;

import com.companystock.model.StockModel;
import org.springframework.stereotype.Service;

@Service
public interface IStockService {

    public StockModel getStockByCompanyCode(long companyCode);

    public StockModel saveStock(StockModel stock);

    public StockModel updateStock(StockModel cmp);

      }
