package com.example.Vegetables;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ItemAndUserJoinedWithFarmerId {

	@Id
	private Integer id;
	private String name;
	private Integer price;
	private Integer farmerId;
	private String farmerName;

}
