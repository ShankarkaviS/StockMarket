package com.hcl.OnlineStock.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockRequestDto {
	
private Long stockId;
private double quantity;
	
}
