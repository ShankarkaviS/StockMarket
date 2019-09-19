package com.hcl.OnlineStock.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hcl.OnlineStock.dto.StockRequestDto;
import com.hcl.OnlineStock.dto.StockResponseDto;
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
		final	String url="http://localhost:8111/getStock/"+stockId+"";
		Stock stock=restTemplate().getForObject(url, Stock.class, stockId);	
		StockData stocks= new StockData();
		stocks.setUserId(1L);
		stocks.setQuantity(stock.getQuantity());
		stocks.setStockId(stock.getStockId());
		stocks.setTotal(stock.getQuantity()*stock.getPrice());
		repository.save(stocks);
		return stock;
	}


	@Override
	public StockResponseDto findByNameAndQuantitys(Long stockId, double quantity) {
		
		final	String url="http://localhost:8111/getStock/"+stockId+"";
		Stock stock=restTemplate().getForObject(url, Stock.class, stockId);	
		
		StockData sData= new StockData();
		StockResponseDto response= new StockResponseDto();
		StockRequestDto request= new StockRequestDto();
	 
	 if(stock.getStockName().isEmpty()||stock.getStockName()==null)
	 {
	 throw new com.hcl.OnlineStock.exception.StockNotAvaliableException("Stock Not Avaliable");
	 }else
	 {
		if(stock.getQuantity()>=quantity) 
		{
			sData.setQuantity(quantity);
			sData.setStockId(stockId);
			sData.setUserId(2L);
			sData.setPrice(stock.getPrice());
			sData.setTotal(quantity*stock.getPrice());
			response.setPrice(stock.getPrice());
			response.setQuantity(quantity);
			response.setStockId(stock.getStockId());
			response.setStockName(stock.getStockName());
			response.setMessage("Stack Avaliable Success...");
			response.setStatusCode(200);
			request.setQuantity(stock.getQuantity()-quantity);
			request.setStockId(stock.getStockId());
			 repository.save(sData);
			 
			 final	String url2="http://localhost:8111//buyStock"+request+"";
			restTemplate().getForObject(url2, StockResponseDto.class, request);
			
	
		}else
		{
			throw new com.hcl.OnlineStock.exception.SufficientQuantityException("Sufficient Quantity is not avaliable");
		}
	 }	
		return response;
	
	}

}
