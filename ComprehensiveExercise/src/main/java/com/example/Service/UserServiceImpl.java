package com.example.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Repository.UserRepository;
import com.example.User.VUser;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	//ユーザー登録
	@Override
	public void signupUser(VUser signupUser) {

		//パスワード暗号化
		String rawPassword = signupUser.getPassword();
		signupUser.setPassword(encoder.encode(rawPassword));

		repository.save(signupUser);

	}

	//ログインを試みている・またはログイン中のユーザーの取得
	@Override
	public VUser getLoginUser(String userMail) {

		Optional<VUser> option = repository.findByUserMail(userMail);
		VUser user = option.orElse(null);
		return user;

	}

	//主キー（＝商品テーブルの農家ID）でユーザー情報を取得する
	@Override
	public VUser getUserById(Integer userId) {

		String stringUserId = userId.toString();
		Optional<VUser> option = repository.findById(stringUserId);
		VUser user = option.orElse(null);
		return user;

	}

	//主キー（＝商品テーブルの農家ID）でユーザー名を取得する
	@Override
	public String getUserNameById(Integer userId) {

		VUser user = getUserById(userId);
		String userName = user.getUserName();

		return userName;
	}

}
