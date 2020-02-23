package com.shopping.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ITEM")
public class ItemEntity implements Serializable {
    private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue
    private Long id;
     
    @Column(name="name")
    private String name;
     
    @Column(name="description")
    private String description;
     
    @Column(name="price")
    private BigDecimal price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ItemEntity [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + "]";
	}    
    
}
