package com.example.Vegetables.Form;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

//フォームから受け取った内容をバインドするためのクラス
@Data
public class AddForm {

	@NotBlank
	@Max(4)
	private String name;

}
