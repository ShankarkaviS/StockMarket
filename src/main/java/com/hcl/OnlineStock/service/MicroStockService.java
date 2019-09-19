package com.hcl.OnlineStock.service;

import com.hcl.OnlineStock.dto.StockResponseDto;
import com.hcl.OnlineStock.model.Stock;

public interface MicroStockService {
	
	public Stock buyStock(Long stockId);
	public StockResponseDto findByNameAndQuantitys(Long stockId,double quantity);
	

}
