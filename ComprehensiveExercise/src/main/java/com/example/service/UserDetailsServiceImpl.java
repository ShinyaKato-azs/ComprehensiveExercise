package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.user.entity.VUser;

@Service
/** DBのユーザー情報でログイン認証を行うための自作UserDetailsService実装クラス */
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService service;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		//ユーザー情報取得
		VUser loginUser = service.getLoginUser(username);

		//ユーザーが存在しない場合
		if (loginUser == null) {
			throw new UsernameNotFoundException("user not found");
		}

		//権限list作成
		GrantedAuthority authority = new SimpleGrantedAuthority(loginUser.getAuthority());
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(authority);

		//UserDetails作成
		UserDetails userDetails = (UserDetails) new User(loginUser.getUserMail(), loginUser.getPassword(), authorities);

		return userDetails;
	}

}
