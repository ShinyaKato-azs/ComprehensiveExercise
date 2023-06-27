package com.example.Vegetables.Form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

//フォームから受け取った内容をバインドするためのクラス
@Data
public class AddForm {

	@NotBlank
	private String name;

}
