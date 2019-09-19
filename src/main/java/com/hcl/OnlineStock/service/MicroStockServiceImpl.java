package com.hcl.OnlineStock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hcl.OnlineStock.model.Stock;
import com.hcl.OnlineStock.model.StockData;
import com.hcl.OnlineStock.repository.MicroStockRepository;

@Service
public class MicroStockServiceImpl implements MicroStockService{
	
	@Autowired
	private MicroStockRepository repository;
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	
	@Override
	public Stock buyStock(Long stockId) {
		final	String url="http://localhost:8660/getStock/"+stockId+"";
		Stock stock=restTemplate().getForObject(url, Stock.class, stockId);	
		StockData stocks= new StockData();
		stocks.setUserId(1L);
		stocks.setQuantity(stock.getQuantity());
		stocks.setStockId(stock.getStockId());
		stocks.setTotal(stock.getQuantity()*stock.getPrice());
		repository.save(stocks);
		
		return stock;
	}

}
