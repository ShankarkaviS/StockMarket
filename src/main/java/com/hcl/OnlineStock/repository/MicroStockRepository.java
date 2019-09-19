package com.hcl.OnlineStock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.OnlineStock.model.StockData;

@Repository
public interface MicroStockRepository  extends JpaRepository<StockData,Long>{

}
