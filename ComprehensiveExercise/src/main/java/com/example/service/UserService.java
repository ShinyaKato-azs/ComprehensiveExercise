package com.example.service;

import java.util.List;

import com.example.user.entity.FarmerDetail;
import com.example.user.entity.VUser;

/** ユーザーの取得・更新のためのサービスインターフェース */
public interface UserService {

	/** ユーザー登録 */
	public void signupUser(VUser signupUser);

	/** メールアドレスでログインユーザー取得 */
	public VUser getLoginUser(String userMail);

	/** ユーザーIDでユーザー情報を取得する */
	public VUser getUserById(Integer userId);

	/** ユーザーIDでユーザー名を取得する */
	public String getUserNameById(Integer userId);

	/** ユーザーIDでFarmerDetailクラスのフィールド要素を取得（全件） */
	public List<FarmerDetail> getFarmerDetails(Integer farmerId);

}
