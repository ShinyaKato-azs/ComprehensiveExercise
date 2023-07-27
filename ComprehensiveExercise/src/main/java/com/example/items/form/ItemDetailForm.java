package com.example.items.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

//フォームから受け取った内容をバインドするためのクラス
@Data
public class ItemDetailForm {

	private Integer id;
	@NotBlank
	private String name;
	private Integer price;
	private Integer farmerId;
	private String farmerName;

}
