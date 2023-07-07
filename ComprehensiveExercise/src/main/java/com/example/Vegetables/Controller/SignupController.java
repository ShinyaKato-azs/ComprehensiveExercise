package com.example.Vegetables.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Repository.UserRepository;
import com.example.User.User;
import com.example.Vegetables.Form.SignupForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SignupController {

	@Autowired
	private UserRepository repository;

	@Autowired
	private User signupUser;

	@GetMapping("/signup")
	public String getSignup(@ModelAttribute SignupForm form) {

		return ("user/signup");
	}

	@PostMapping("/signup")
	public String postSignup(@ModelAttribute SignupForm form) {

		//登録処理
		signupUser.setUserId(form.getUserId());
		signupUser.setPassword(form.getPassword());

		//ログ出力して確認
		log.info(signupUser.toString());
		log.info(form.toString());

		//テーブルに登録
		repository.save(signupUser);

		return "redirect:/signup";
	}

}
