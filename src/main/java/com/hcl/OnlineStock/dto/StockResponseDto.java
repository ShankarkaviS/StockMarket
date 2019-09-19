package com.hcl.OnlineStock.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockResponseDto {
	private Long stockId;
	private String stockName;
	private double quantity;
	private double price;
	private String message;
	private int statusCode;
	
	

}
