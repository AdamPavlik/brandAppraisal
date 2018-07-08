package com.market.exceptions;

public class MarketException extends Exception {
	public MarketException() {
		super("Sorry, Something went wrong, Let's try again!)");
	}

	public MarketException(String message) {
		super(message);
	}
}
