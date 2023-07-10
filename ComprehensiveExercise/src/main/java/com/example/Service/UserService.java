package com.example.Service;

import com.example.User.VUser;

public interface UserService {

	//ユーザー登録
	public void signupUser(VUser signupUser);

	//ユーザー取得
	public VUser getLoginUser(String userId);

}
