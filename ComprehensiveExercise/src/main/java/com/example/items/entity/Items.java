package com.example.items.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "items")
/** 商品のエンティティクラス */
public class Items {

	/** 商品ID（DB側の処理で自動的に連番で振られる） */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** 商品名 */
	private String name;

	/** 価格 */
	private Integer price;

	/** 農家ID：商品を登録した農家のユーザーID */
	private Integer farmerId;
}
