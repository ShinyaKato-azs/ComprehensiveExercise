package com.example.user.form;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
/** ログイン画面のフォームとバインドするためのクラス */
public class SignupForm {

	/** ユーザーID */
	private Integer userId;

	/** 
	 * メールアドレス
	 * 空文字や半角スペースのみは不可
	 * メールアドレス形式のみを許可
	 */
	@NotBlank
	@Email
	private String userMail;

	/** 
	 * パスワード
	 * 空文字や半角スペースのみは不可
	 * 大文字小文字の英数字＋記号のみ許可
	 * 4文字以上100文字以下
	 */
	@NotBlank
	@Length(min = 4, max = 100)
	@Pattern(regexp = "^[a-zA-Z0-9]+$")
	private String password;

	/** 
	 * ユーザー名
	 * 空文字や半角スペースのみは不可
	 */
	@NotBlank
	private String userName;

	/** 
	 * 権限
	 * ラジオボタンで必ず選択する
	 */
	@NotBlank
	private String authority;

}
