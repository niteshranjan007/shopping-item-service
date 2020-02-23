package com.shopping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.exception.RecordNotFoundException;
import com.shopping.entity.ItemEntity;
import com.shopping.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemRepository repository;

	public List<ItemEntity> getAllItems()
	{
		List<ItemEntity> itemList = repository.findAll();

		if(itemList.size() > 0) {
			return itemList;
		} else {
			return new ArrayList<ItemEntity>();
		}
	}

	public ItemEntity createOrUpdateItem(ItemEntity entity) throws RecordNotFoundException 
	{
		Optional<ItemEntity> item = repository.findById(entity.getId());

		if(item.isPresent()) 
		{
			ItemEntity newEntity = item.get();
			newEntity.setName(entity.getName());
			newEntity.setDescription(entity.getDescription());
			newEntity.setPrice(entity.getPrice());

			newEntity = repository.save(newEntity);

			return newEntity;
		} else {
			entity = repository.save(entity);

			return entity;
		}
	} 

	public ItemEntity getItemByName(String name) throws RecordNotFoundException 
	{
		Optional<ItemEntity> item = repository.findByName(name);

		if(item.isPresent()) {
			return item.get();
		} else {
			throw new RecordNotFoundException("No Item record exist for given id");
		}
	}

	public void deleteItemByName(String name) throws RecordNotFoundException 
	{
		Optional<ItemEntity> item = repository.findByName(name);

		if(item.isPresent()) 
		{
			repository.deleteByName(name);
		} else {
			throw new RecordNotFoundException("No Item record exist for given id");
		}
	} 
}