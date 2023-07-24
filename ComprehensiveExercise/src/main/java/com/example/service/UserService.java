package com.example.service;

import java.util.List;

import com.example.user.FarmerDetail;
import com.example.user.VUser;

public interface UserService {

	//ユーザー登録
	public void signupUser(VUser signupUser);

	//ログインユーザー取得
	public VUser getLoginUser(String userMail);

	//主キー（＝商品テーブルでは農家ID）でユーザー情報を取得する
	public VUser getUserById(Integer userId);

	//主キーでユーザー名を取得する
	public String getUserNameById(Integer userId);

	//主キーで農家の詳細情報（id、名前、取り扱い野菜）を取得
	public List<FarmerDetail> getFarmerDetails(Integer farmerId);

}
