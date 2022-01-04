package com.yahoo.finance.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yahoo.finance.model.Stock;
import com.yahoo.finance.service.YahooFinanceService;

import yahoofinance.YahooFinance;

@Service
public class YahooFinanceServiceImpl implements YahooFinanceService {
	
	private Map<String, Stock> stockMap;

	@SuppressWarnings("null")
	@Override
	public List<Stock> getAllStockQuotes() {
		// TODO Auto-generated method stub
		try {
			
			if(null == stockMap || stockMap.isEmpty()) {
				stockMap = new HashMap<>();
				String[] symbols = new String[] {"INTC", "BABA", "TSLA", "AIR.PA", "YHOO"};
				Map<String, yahoofinance.Stock> financeStocks = YahooFinance.get(symbols);
				
				for(String symbol: symbols) {
					Stock stock = new Stock();
					yahoofinance.Stock ticker = financeStocks.get(symbol);
					stock.setSymbol(ticker.getSymbol());
					stock.setName(ticker.getName());
					stock.setPrice(ticker.getQuote().getPrice());
					stock.setWatch(true);
					stockMap.put(ticker.getSymbol(), stock);
				}
				
			}
			else {
				return stockMap.values().stream().toList();
			}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stockMap.values().stream().toList();
	}

	@Override
	public Stock getSpecificStockQuotes(String stockName) {
		// TODO Auto-generated method stub
		Stock stock = new Stock();
		try {
			if(null == stockMap || stockMap.isEmpty()) {
				stockMap = new HashMap<>();
				yahoofinance.Stock financeStock = YahooFinance.get(stockName);
				if(financeStock!=null) {
					stock.setName(financeStock.getName());
					stock.setSymbol(financeStock.getSymbol());
					stock.setPrice(financeStock.getQuote().getPrice());
					stock.setWatch(true);
					stockMap.put(financeStock.getSymbol(), stock);
				}
				else {
					return stock;
				}
			}
			else if(stockMap.containsKey(stockName)) {
				return stockMap.get(stockName);
			}
			else {
				yahoofinance.Stock financeStock = YahooFinance.get(stockName);
				if(financeStock!=null) {
					stock.setName(financeStock.getName());
					stock.setSymbol(financeStock.getSymbol());
					stock.setPrice(financeStock.getQuote().getPrice());
					stock.setWatch(true);
					stockMap.put(financeStock.getSymbol(), stock);
				}
				else {
					return stock;
				}
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return stock;
	}
	
	@Override
	public Stock addSpecificStockQuotes(String stockName) {
		// TODO Auto-generated method stub
		Stock stock = new Stock();
		try {
			if(null == stockMap || stockMap.isEmpty()) {
				stockMap = new HashMap<>();
				yahoofinance.Stock financeStock = YahooFinance.get(stockName);
				if(financeStock!=null) {
					stock.setName(financeStock.getName());
					stock.setSymbol(financeStock.getSymbol());
					stock.setPrice(financeStock.getQuote().getPrice());
					stock.setWatch(true);
					stockMap.put(financeStock.getSymbol(), stock);
				}
				else {
					return stock;
				}
			}
			else if(stockMap.containsKey(stockName)) {
				return stockMap.get(stockName);
			}
			else {
				yahoofinance.Stock financeStock = YahooFinance.get(stockName);
				if(financeStock!=null) {
					stock.setName(financeStock.getName());
					stock.setSymbol(financeStock.getSymbol());
					stock.setPrice(financeStock.getQuote().getPrice());
					stock.setWatch(true);
					stockMap.put(financeStock.getSymbol(), stock);
				}
				else {
					return stock;
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return stock;
	}
	
	@Override
	public String removeSpecificStockQuotes(String stockName) {
		// TODO Auto-generated method stub
		if(null == stockMap || stockMap.isEmpty()) {
			return "Cant Find the Stock in watchlist, please add it before removing: " + stockName;
		}
		else if(stockMap.containsKey(stockName)) {
			stockMap.remove(stockName, stockMap.get(stockName));
			return "Stock has been removed: "+ stockName;
		}
		
		
		return "Cant Find the Stock in watchlist: " + stockName;
	}
	
	public List<Stock> getWatchedStocksQuotes() {
		// TODO Auto-generated method stub
		try {
			
			if(null == stockMap || stockMap.isEmpty()) {
				return null;
			}
			else {
				return stockMap.values().stream().toList();
			}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BigDecimal getAvgPriceWatchedStocks() {
		// TODO Auto-generated method stub
		
		if(null == stockMap || stockMap.isEmpty()) {
			return BigDecimal.ZERO ;
		}
		else {
			return stockMap.values().stream().filter(d->d.getPrice()!=null).map(d->d.getPrice()).reduce(BigDecimal.ZERO, BigDecimal::add);
		}
	}
	
	
	
	

}
