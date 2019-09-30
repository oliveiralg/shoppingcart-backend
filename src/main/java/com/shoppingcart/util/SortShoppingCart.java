package com.shoppingcart.util;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.shoppingcart.entity.Item;

public class SortShoppingCart {

	static public List<Item> sortShoppingCart(List<Item> items)
	{
		List<Item> sortedList = items.stream().sorted(Comparator.comparing(Item::getName))
				.collect(Collectors.toList());
		return sortedList;
	}
}
