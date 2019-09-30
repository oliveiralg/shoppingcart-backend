package com.shoppingcart.restful.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shoppingcart.entity.Item;
import com.shoppingcart.repository.ItemRepository;
import com.shoppingcart.util.SortShoppingCart;

@CrossOrigin
@RestController
public class WebRestController {

	
	@Autowired
    private ItemRepository repository;
	
	private List<Item> getShoppingCart() {
		/*List<Item> cartList = new ArrayList<>();
		Item item = new Item();
		item.setId(1L);
		item.setName("IPhone 11 Pro");
		item.setValue(999.00);
		cartList.add(item);

		item = new Item();
		item.setId(2L);
		item.setName("MacBook Pro");
		item.setValue(2799.00);
		cartList.add(item);

		item = new Item();
		item.setId(3L);
		item.setName("Apple Watch Series 5");
		item.setValue(399.00);
		cartList.add(item);

		return cartList;*/
		
		Iterable<Item> repositoryList = repository.findAll();
		List<Item> cartList = new ArrayList<>();
		for (Item t : repositoryList) 
			cartList.add(t); 
		return cartList;
	}

	@RequestMapping("/api/cart")
	public String ShowCart() {
		Gson gsonBuilder = new GsonBuilder().create();
		// Convert Java Array into JSON
		String jsonFromJavaArrayList = gsonBuilder.toJson(getShoppingCart());
		return jsonFromJavaArrayList;
	}

	@RequestMapping("/api/cart/sort")
	public String getSortedCart() {

		List<Item> sortedList = SortShoppingCart.sortShoppingCart(getShoppingCart());

		Gson gsonBuilder = new GsonBuilder().create();
		// Convert Java Array into JSON
		String jsonFromJavaArrayList = gsonBuilder.toJson(sortedList);
		return jsonFromJavaArrayList;
	}
}