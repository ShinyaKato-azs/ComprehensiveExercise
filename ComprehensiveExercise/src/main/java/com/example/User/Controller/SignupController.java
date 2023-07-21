package com.example.User.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Service.UserService;
import com.example.User.VUser;
import com.example.User.Form.SignupForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SignupController {

	//	@Autowired
	//	private UserRepository repository;

	@Autowired
	private VUser user;

	@Autowired
	private UserService userService;

	@GetMapping("/signup")
	public String getSignup(@ModelAttribute SignupForm form) {

		return ("user/signup");
	}

	@PostMapping("/signup")
	public String postSignup(@ModelAttribute @Validated SignupForm form,
			BindingResult bindingResult) {

		//バリデーション
		if (bindingResult.hasErrors()) {

			return getSignup(form);

		}
		//フォームのコピー
		//IdはDB側で自動採番されるため、nullで設定する
		user.setUserId(null);
		user.setUserMail(form.getUserMail());
		user.setPassword(form.getPassword());
		user.setUserName(form.getUserName());
		user.setAuthority(form.getAuthority());

		//ログ出力して確認
		log.info("エンティティクラスの中身:" + user.toString());
		log.info("フォームの中身:" + form.toString());

		//テーブルに登録
		userService.signupUser(user);

		return "redirect:/login";
	}

}
