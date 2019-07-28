package com.neusoft.spring.domain;

public class BankCard {

	private String cardName;

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public BankCard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankCard(String cardName) {
		super();
		this.cardName = cardName;
	}

	@Override
	public String toString() {
		return "BankCard [cardName=" + cardName + "]";
	}
	
}
