package com.example.user.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Component
@Table(name = "v_user")
/** ユーザーのエンティティクラス */
public class VUser {

	/** 
	 * ユーザーID
	 * DB側で自動的に連番を振られる
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	/** 
	 * 登録メールアドレス 
	 * SpringSecurityではusername属性として設定している
	 */
	private String userMail;

	/** ユーザー名 */
	private String userName;

	/** パスワード */
	private String password;

	/** 権限（農家もしくは一般ユーザー） */
	private String authority;

}
