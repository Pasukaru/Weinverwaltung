package gui.dialog.cart;

import model.Wine;

public class CartEntry {

	private Wine wine;
	private int amount;
	
	public CartEntry(Wine wine){
		this.wine = wine;
		this.amount = 1;
	}
	
	public Wine getWine(){
		return wine;
	}
	
	public int getAmount(){
		return amount;
	}
	
	public void setAmount(int amount){
		this.amount = amount;
	}
}
