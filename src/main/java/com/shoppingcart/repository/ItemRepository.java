package com.shoppingcart.repository;

import org.springframework.data.repository.CrudRepository;

import com.shoppingcart.entity.Item;

public interface ItemRepository extends CrudRepository<Item, Long>{

}
