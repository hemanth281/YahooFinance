package com.yahoo.finance.model;

import java.io.Serializable;
import java.util.List;

public class StockQuotes implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private List<Stock> stock;

	/**
	 * @return the stock
	 */
	public List<Stock> getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(List<Stock> stock) {
		this.stock = stock;
	}
	
	@Override
	public String toString() {
		return "StockQuotes [stock=" + stock + "]";
	}
	
}
