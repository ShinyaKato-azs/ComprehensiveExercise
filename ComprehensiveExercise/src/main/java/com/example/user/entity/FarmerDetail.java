package com.example.user.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@Component
/** 農家詳細画面のエンティティクラス */
public class FarmerDetail {

	@Column(name = "farmer_id")
	private Integer farmerId;
	@Column(name = "farmer_name")
	private String farmerName;
	//取り扱っている野菜名前
	@Id
	@Column(name = "farmer_items_name")
	private String farmerItemsName;

}
