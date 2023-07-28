package com.example.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
/** ログイン画面のコントローラー */
public class LoginController {

	@GetMapping("/login")
	public String getLogin() {
		return "/user/login";
	}

	@PostMapping("/login")
	public String postLogin() {
		return "redirect:/";
	}

}
