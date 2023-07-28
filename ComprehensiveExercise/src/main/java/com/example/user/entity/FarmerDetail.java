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

	/** 農家ID */
	@Column(name = "farmer_id")
	private Integer farmerId;

	/** 農家名 */
	@Column(name = "farmer_name")
	private String farmerName;

	/** 
	 * 取り扱い商品名
	 *  */
	@Id
	@Column(name = "farmer_items_name")
	private String farmerItemsName;

}
