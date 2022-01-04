package com.yahoo.finance.service;

import java.math.BigDecimal;
import java.util.List;

import com.yahoo.finance.model.Stock;


public interface YahooFinanceService {

	List<Stock> getAllStockQuotes();
	
	Stock getSpecificStockQuotes(String stockName);
	
	Stock addSpecificStockQuotes(String stockName);
	
	String removeSpecificStockQuotes(String stockName);
	
	List<Stock> getWatchedStocksQuotes();
	
	BigDecimal getAvgPriceWatchedStocks();
}
