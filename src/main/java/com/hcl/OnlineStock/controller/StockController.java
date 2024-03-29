package com.hcl.OnlineStock.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.OnlineStock.model.Stock;
import com.hcl.OnlineStock.service.MicroStockService;

@RestController
public class StockController {
    @Autowired
	MicroStockService  microStockService ;
    
	@GetMapping("/WelStock/{id}")
	public ResponseEntity<Stock> buyStock(@PathVariable("id") Long id)
	{
		return new ResponseEntity<>(microStockService.buyStock(id),HttpStatus.OK); 	
	}
	
	@PutMapping("/buyStock")
	public ResponseEntity<com.hcl.OnlineStock.dto.StockResponseDto> getStock(@RequestBody com.hcl.OnlineStock.dto.StockRequestDto stock )
	{
		return new ResponseEntity<>(microStockService.findByNameAndQuantitys(stock.getStockId(), stock.getQuantity()),HttpStatus.OK);

	}
	
}
