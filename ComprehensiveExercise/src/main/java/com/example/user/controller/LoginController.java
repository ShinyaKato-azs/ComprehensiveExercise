package com.example.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
/** ログイン画面のコントローラー */
public class LoginController {

	/** ログイン画面を返す */
	@GetMapping("/login")
	public String getLogin() {
		return "/user/login";
	}

	/** ログイン画面のフォームを受け取る（ログインの処理はSpringSecurityが担う） */
	@PostMapping("/login")
	public String postLogin() {
		return "redirect:/";
	}

}
