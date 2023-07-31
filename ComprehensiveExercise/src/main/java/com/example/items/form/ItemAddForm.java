package com.example.items.form;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/** 商品追加画面のフォームとバインドするためのクラス */
@Data
public class ItemAddForm {

	/**
	 *商品名
	 *空文字や半角スペースのみは不可
	 *文字数は4文字まで
	*/
	@NotBlank
	@Size(min = 0, max = 4)
	private String name;

	/**
	 * 価格
	 * マイナスの値とnullは不可
	 */
	@NotNull
	@Min(0)
	private Integer price;

	/**
	 * 農家ID
	 */
	private Integer farmerId;

}
