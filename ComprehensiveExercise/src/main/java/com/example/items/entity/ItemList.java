package com.example.items.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ItemList {

	@Id
	@Column(name = "item_id")
	private Integer itemId;
	@Column(name = "name")
	private String name;
	@Column(name = "price")
	private Integer price;
	@Column(name = "farmer_id")
	private Integer farmerId;
	@Column(name = "farmer_name")
	private String farmerName;

}
