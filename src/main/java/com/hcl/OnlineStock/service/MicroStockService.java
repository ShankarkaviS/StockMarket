package com.hcl.OnlineStock.service;

import com.hcl.OnlineStock.dto.StockRequestDto;
import com.hcl.OnlineStock.dto.StockResponseDto;
import com.hcl.OnlineStock.model.Stock;

public interface MicroStockService {
	
	public Stock buyStock(Long stockId);

}
