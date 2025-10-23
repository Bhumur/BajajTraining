package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Stock;
import com.example.demo.model.StockDto;

@Service
public class StockService {

	@Autowired
	JpaRepository<Stock, Integer> repo;
	
	public StockDto add(StockDto stockDto) {
		return mapStockToStockDto(repo.save(mapStockDtoToStock(stockDto)));
	}
	
	private StockDto mapStockToStockDto(Stock stock) {
		if(stock==null)
			new StockDto(0, null, null, 0);
		return new StockDto(stock.getProductId(), 
				stock.getProductName(),
				stock.getWarehouseLocation(),
				stock.getQuantity());
	}

	private Stock mapStockDtoToStock(StockDto dto) {
		if(dto==null)
			return new Stock();
		return new Stock(dto.productId(), dto.productName(), dto.warehouseLocation(), dto.quantity());
	}
}
