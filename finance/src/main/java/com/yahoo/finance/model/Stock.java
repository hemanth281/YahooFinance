package com.yahoo.finance.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Stock implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String symbol;
	private String name;
	private BigDecimal price;
	private Boolean watch;
	/**
	 * @return the watch
	 */
	public Boolean getWatch() {
		return watch;
	}
	/**
	 * @param watch the watch to set
	 */
	public void setWatch(Boolean watch) {
		this.watch = watch;
	}
	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}
	/**
	 * @param symbol the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Stock [symbol=" + symbol + ", name=" + name + ", price=" + price + ", watch=" + watch + "]";
	}
	

}
