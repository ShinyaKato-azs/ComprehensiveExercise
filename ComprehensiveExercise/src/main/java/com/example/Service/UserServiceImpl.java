package com.example.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Repository.UserRepository;
import com.example.User.VUser;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	//ユーザー登録
	@Override
	public void signupUser(VUser signupUser) {

		repository.save(signupUser);

	}

}
