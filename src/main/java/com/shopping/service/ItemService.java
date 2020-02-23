package com.shopping.service;

import java.util.List;

import com.shopping.exception.RecordNotFoundException;
import com.shopping.entity.ItemEntity;

public interface ItemService {
	
	public List<ItemEntity> getAllItems();
	public ItemEntity createOrUpdateItem(ItemEntity entity) throws RecordNotFoundException;
	public ItemEntity getItemByName(String name) throws RecordNotFoundException;
	public void deleteItemByName(String name) throws RecordNotFoundException;

}
