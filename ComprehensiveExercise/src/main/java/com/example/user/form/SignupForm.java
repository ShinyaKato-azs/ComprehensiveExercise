package com.example.user.form;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
/** ログイン画面のフォームとバインドするためのクラス */
public class SignupForm {

	private Integer userId;
	@NotBlank
	@Email
	private String userMail;
	@NotBlank
	@Length(min = 4, max = 100)
	@Pattern(regexp = "^[a-zA-Z0-9]+$")
	private String password;
	@NotBlank
	private String userName;
	@NotBlank
	private String authority;

}
