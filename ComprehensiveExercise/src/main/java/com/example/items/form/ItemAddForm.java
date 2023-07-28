package com.example.items.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/** 商品追加画面のフォームとバインドするためのクラス */
@Data
public class ItemAddForm {

	@NotBlank
	@Size(min = 0, max = 4)
	private String name;
	private Integer price;
	private Integer farmerId;

}
