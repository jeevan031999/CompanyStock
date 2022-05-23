package com.companystock.repository;

import com.companystock.model.StockModel;

import org.springframework.data.jpa.repository.JpaRepository;


public interface IStockRepository extends JpaRepository<StockModel,Long> {

}
