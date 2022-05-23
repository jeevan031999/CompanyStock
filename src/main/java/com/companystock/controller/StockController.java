package com.companystock.controller;




import com.companystock.model.StockModel;

//import com.companystock.service.IStockService;
import com.companystock.service.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class StockController {
    @Autowired
    IStockService istockService;

    @PostMapping("/saveStock")
    public ResponseEntity<StockModel> saveStock(@RequestBody StockModel stockModel) {
        istockService.saveStock(stockModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{companyCode}").buildAndExpand(stockModel.getId()).toUri();
        return ResponseEntity.created(uri).body(stockModel);
    }

    @PutMapping("/updateStock/{companyCode}")
    public String updateStock(@RequestBody StockModel stockmodel, @PathVariable long companyCode) {
        istockService.updateStock(stockmodel);
        return "Stock updated successfully";
    }
}

