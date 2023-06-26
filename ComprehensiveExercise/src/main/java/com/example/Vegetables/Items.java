package com.example.Vegetables;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "items")
public class Items {

	@Id
	private Integer id;
	private String name;

}
