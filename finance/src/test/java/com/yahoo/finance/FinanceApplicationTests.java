package com.yahoo.finance;



import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yahoo.finance.model.Stock;
import com.yahoo.finance.service.YahooFinanceService;

import yahoofinance.YahooFinance;

@SpringBootTest
class FinanceApplicationTests {
	
	@Autowired
	private YahooFinanceService yahooFinanceService;
	
	@BeforeAll
    static void init() {
        System.out.println("Only run once before all tests");
    }
	
	@Test 
	public void testGetAllStockQuotes() throws Exception {
		
		List<Stock> stocks = new ArrayList<>();
		stocks= yahooFinanceService.getAllStockQuotes();
		assertNotNull(stocks);
	}
	
	@Test 
	public void testGetSpecificStockQuotes() throws Exception {
		
		Stock stock = new Stock();
		String stockName = "INTC";
		assertNotNull(stock);
		assertEquals(stockName, yahooFinanceService.getSpecificStockQuotes(stockName).getSymbol());
	}
	
	@Test 
	public void testAddSpecificStockQuotes() throws Exception {
		
		Stock stock = new Stock();
		String stockName = "Alpa";
		assertNotNull(stock);
		assertEquals(stockName, yahooFinanceService.addSpecificStockQuotes(stockName).getSymbol());
	}
	
	@Test 
	public void testRemoveSpecificStockQuotes() throws Exception {
		
		Stock stock = new Stock();
		String stockName = "Alpa";
		yahooFinanceService.addSpecificStockQuotes(stockName);
		yahooFinanceService.removeSpecificStockQuotes(stockName);
		yahoofinance.Stock financeStock = YahooFinance.get(stockName);
		if(financeStock!=null) {
			stock.setName(financeStock.getName());
			stock.setSymbol(financeStock.getSymbol());
			stock.setPrice(financeStock.getQuote().getPrice());
			stock.setWatch(true);
		}
		assertNotNull(yahooFinanceService.getWatchedStocksQuotes().contains(stock));
		assertFalse(yahooFinanceService.getWatchedStocksQuotes().contains(stock));
	}
	
	@Test 
	public void testGetWatchedStocksQuotes() throws Exception {
		
		Stock stock = new Stock();
		String stockName = "Alpa";
		yahooFinanceService.addSpecificStockQuotes(stockName);
		yahoofinance.Stock financeStock = YahooFinance.get(stockName);
		if(financeStock!=null) {
			stock.setName(financeStock.getName());
			stock.setSymbol(financeStock.getSymbol());
			stock.setPrice(financeStock.getQuote().getPrice());
			stock.setWatch(true);
		}
		assertNotNull(yahooFinanceService.getWatchedStocksQuotes().contains(stock));
	}
	
	@Test 
	public void testGetAvgPriceWatchedStocks() throws Exception {
		yahooFinanceService.getAllStockQuotes();
		assertNotNull(yahooFinanceService.getAvgPriceWatchedStocks());
	}
}
