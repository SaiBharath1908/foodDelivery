package com.dao.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	private Map<Integer, CardItem> myCart;
	
	public Cart() {
		this.myCart= new HashMap();
	}
	 public void addItems(CardItem item) {
		 int item_id = item.getMenu_id();
		 if(myCart.containsKey(item_id)) {
			 CardItem existingItem = myCart.get(item_id);
			 existingItem.setQunantity(existingItem.getQunantity()+ item.getQunantity());
		 }
		 else {
			 myCart.put(item_id, item);
		 }
		 
	 }
	 
	 public void remove(int item_id) {
		 myCart.remove(item_id);
	 }
	 
	 public void clear() {
		 myCart.clear();
	 }
	 
	 public Map<Integer, CardItem> getItems(){
		 return myCart;
	 }

	 public void update(int itemId , int qunantity) {
		 if(myCart.containsKey(itemId)) {
			 if(qunantity <= 0) {
				 myCart.remove(itemId);
			 }
			 else {
				 myCart.get(itemId).setQunantity(qunantity);
			 }
		 }
	 }
}

