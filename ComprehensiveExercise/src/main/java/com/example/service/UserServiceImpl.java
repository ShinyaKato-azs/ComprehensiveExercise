package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.repository.FarmerDetailRepository;
import com.example.repository.UserRepository;
import com.example.user.FarmerDetail;
import com.example.user.VUser;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private FarmerDetailRepository farmerDetailRepo;

	@Autowired
	private BCryptPasswordEncoder encoder;

	//ユーザー登録
	@Override
	public void signupUser(VUser signupUser) {

		//パスワード暗号化
		String rawPassword = signupUser.getPassword();
		signupUser.setPassword(encoder.encode(rawPassword));

		userRepo.save(signupUser);

	}

	//ログインを試みている・またはログイン中のユーザーの取得
	@Override
	public VUser getLoginUser(String userMail) {

		Optional<VUser> option = userRepo.findByUserMail(userMail);
		VUser user = option.orElse(null);
		return user;

	}

	//主キー（＝商品テーブルの農家ID）でユーザー情報を取得する
	@Override
	public VUser getUserById(Integer userId) {

		String stringUserId = userId.toString();
		Optional<VUser> option = userRepo.findById(stringUserId);
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

	//主キーで農家の詳細情報（id、名前、取り扱い野菜）を取得
	@Override
	public List<FarmerDetail> getFarmerDetails(Integer farmerId) {

		List<FarmerDetail> farmerDetailList = farmerDetailRepo.getFarmerDetails(farmerId);

		return farmerDetailList;
	}

}
