package com.yahoo.finance.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

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
	
	@Override
	public int hashCode() {
		return Objects.hash(name, price, symbol, watch);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stock other = (Stock) obj;
		return Objects.equals(name, other.name) && Objects.equals(price, other.price)
				&& Objects.equals(symbol, other.symbol) && Objects.equals(watch, other.watch);
	}
}
