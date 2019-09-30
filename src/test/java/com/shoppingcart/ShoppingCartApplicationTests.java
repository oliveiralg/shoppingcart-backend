package com.shoppingcart;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.shoppingcart.entity.Item;
import com.shoppingcart.repository.ItemRepository;
import com.shoppingcart.util.SortShoppingCart;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingCartApplicationTests {

	@Autowired
	private ItemRepository itemRepository;

	@Test
	public void getAllRecords() {
		Iterable<Item> repositoryList = itemRepository.findAll();
		if (repositoryList instanceof Collection<?>) {
			assertEquals(((Collection<?>)repositoryList).size(),3);
		}
	}
	
	@Test
	public void checkSortedCart() {
		Iterable<Item> repositoryList = itemRepository.findAll();
		List<Item> cartList = new ArrayList<>();
		for (Item t : repositoryList) 
			cartList.add(t);
		
		List<Item> sortedList = SortShoppingCart.sortShoppingCart(cartList);
		Item item = sortedList.iterator().next();
		assertEquals(item.getName(),"Apple Watch Series 5");
	}

}
