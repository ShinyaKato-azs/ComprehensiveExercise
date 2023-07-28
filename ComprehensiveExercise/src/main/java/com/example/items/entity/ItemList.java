package com.example.items.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
/** 
 * 商品一覧画面のエンティティクラス
 * 商品テーブルとユーザーテーブルを農家IDで結合して、農家名を取得するクエリの結果を受け取っている
 */
public class ItemList {

	/** 商品ID  */
	@Id
	@Column(name = "item_id")
	private Integer itemId;

	/** 商品名  */
	@Column(name = "name")
	private String name;

	/** 価格  */
	@Column(name = "price")
	private Integer price;

	/** 農家ID：商品を登録した農家のユーザーID  */
	@Column(name = "farmer_id")
	private Integer farmerId;

	/** 農家名  */
	@Column(name = "farmer_name")
	private String farmerName;

}
