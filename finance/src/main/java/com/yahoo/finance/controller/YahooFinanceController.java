package com.yahoo.finance.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yahoo.finance.model.Stock;
import com.yahoo.finance.service.YahooFinanceService;

@RestController
@RequestMapping("/finance")
public class YahooFinanceController {

	@Autowired
	private YahooFinanceService yahooFinanceService;
	
	@RequestMapping(value="/stock/quotes", method= RequestMethod.GET)
	public List<Stock> getAllStockQuotes(){
		return yahooFinanceService.getAllStockQuotes();
	}
	
	@RequestMapping(value="/stock/quotes/{stock}", method = RequestMethod.GET)
	public Stock getSpecificStockQuotes(@PathVariable(value="stock") String stock){
		return yahooFinanceService.getSpecificStockQuotes(stock.toUpperCase());	
	}
	
	@RequestMapping(value="/stock/quotes/add/{stock}", method = RequestMethod.GET)
	public Stock addSpecificStockQuotes(@PathVariable(value="stock") String stock){
		return yahooFinanceService.addSpecificStockQuotes(stock.toUpperCase());	
	}
	
	@RequestMapping(value="/stock/quotes/remove/{stock}", method = RequestMethod.GET)
	public String removeSpecificStockQuotes(@PathVariable(value="stock") String stock){
		return yahooFinanceService.removeSpecificStockQuotes(stock.toUpperCase());	
	}
	
	@RequestMapping(value="/stock/quotes/watchList", method = RequestMethod.GET)
	public List<Stock> getWatchedStocksQuotes(){
		return yahooFinanceService.getWatchedStocksQuotes();	
	}
	
	@RequestMapping(value="/stock/quotes/avgprice", method = RequestMethod.GET)
	public BigDecimal getAvgPriceWatchedStocks(){
		return yahooFinanceService.getAvgPriceWatchedStocks();
		
		
		
	}
	
}
