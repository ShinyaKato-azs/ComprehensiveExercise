package com.example.items.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/** 商品詳細画面にデータを渡して、フォームとバインドするためのクラス */
@Data
public class ItemDetailForm {

	private Integer id;
	@NotBlank
	private String name;
	private Integer price;
	private Integer farmerId;
	private String farmerName;

}
