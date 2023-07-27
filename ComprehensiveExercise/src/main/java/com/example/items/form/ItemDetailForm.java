package com.example.items.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

//フォームから受け取った内容をバインドするためのクラス
@Data
public class ItemDetailForm {

	private Integer id;
	@NotBlank
	@Size(min = 0, max = 4)
	private String name;
	private Integer price;
	private Integer farmerId;
	private String farmerName;

}
