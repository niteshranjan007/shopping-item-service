package com.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.entity.ItemEntity;
import com.shopping.exception.RecordNotFoundException;
import com.shopping.service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {
	
	    @Autowired
	    ItemService service;
	    
	    @GetMapping
	    public ResponseEntity<List<ItemEntity>> getAllItems() {
	        List<ItemEntity> list = service.getAllItems();
	 
	        return new ResponseEntity<List<ItemEntity>>(list, new HttpHeaders(), HttpStatus.OK);
	    }
	 
	    @GetMapping("/{name}")
	    public ResponseEntity<ItemEntity> getItemById(@PathVariable("name") String name) throws RecordNotFoundException {
	    	ItemEntity entity = service.getItemByName(name);
	 
	        return new ResponseEntity<ItemEntity>(entity, new HttpHeaders(), HttpStatus.OK);
	    }
	 
	    @PostMapping
	    public ResponseEntity<ItemEntity> createOrUpdateItem(@RequestBody ItemEntity Item) throws RecordNotFoundException {
	    	ItemEntity updated = service.createOrUpdateItem(Item);
	        return new ResponseEntity<ItemEntity>(updated, new HttpHeaders(), HttpStatus.OK);
	    }
	 
	    @DeleteMapping("/{name}")
	    public HttpStatus deleteItemByName(@PathVariable("name") String name) throws RecordNotFoundException {
	        service.deleteItemByName(name);
	        return HttpStatus.FORBIDDEN;
	    }

}
