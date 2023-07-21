package com.example.service;

import com.example.user.VUser;

public interface UserService {

	//ユーザー登録
	public void signupUser(VUser signupUser);

	//ログインユーザー取得
	public VUser getLoginUser(String userMail);

	//主キー（＝商品テーブルの農家ID）でユーザー情報を取得する
	public VUser getUserById(Integer userId);

	//主キー（＝商品テーブルの農家ID）でユーザー名を取得する
	public String getUserNameById(Integer userId);

}
