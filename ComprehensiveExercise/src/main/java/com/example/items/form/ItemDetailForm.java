package com.example.items.form;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/** 商品詳細画面にデータを渡して、フォームとバインドするためのクラス */
@Data
public class ItemDetailForm {

	/** 商品ID */
	private Integer id;
	/**
	 *商品名
	 *空文字や半角スペースのみは不可
	 *更新処理では、文字数の制限なし
	*/
	@NotBlank
	private String name;

	/**
	 *価格
	 *マイナスの値は不可
	*/
	@Min(0)
	private Integer price;

	/** 農家ID */
	private Integer farmerId;

	/** 農家名 */
	private String farmerName;

}
