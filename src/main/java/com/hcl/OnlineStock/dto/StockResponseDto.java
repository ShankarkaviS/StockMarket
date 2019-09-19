package com.hcl.OnlineStock.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockResponseDto {
	private Long stockId;
	private String stockName;
	private double quantity;
	private double price;
	private String message;
	private int statusCode;

}
