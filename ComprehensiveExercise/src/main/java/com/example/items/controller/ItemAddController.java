package com.example.items.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.items.entity.Items;
import com.example.items.form.ItemAddForm;
import com.example.service.ItemService;
import com.example.service.UserService;
import com.example.user.entity.VUser;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
/** 商品追加画面のコントローラー */
public class ItemAddController {

	@Autowired
	private ItemService itemService;

	@Autowired
	private UserService userService;

	@GetMapping("/add")
	public String getItemAdd(@ModelAttribute ItemAddForm form, Model model,
			@AuthenticationPrincipal UserDetails userDetails) {

		/*
		 * 商品追加時に農家IDを自動で登録するために、
		 * ログイン中のユーザーを取得する
		 */
		String loginUserMail = userDetails.getUsername();
		VUser loginUser = userService.getLoginUser(loginUserMail);
		model.addAttribute("loginUser", loginUser);

		/* htmlの商品追加フォームはAddFormとバインドしているため、
		 * AddFormの農家IDフィールドにログイン中のユーザーのIDをセットして渡しておく
		 */
		form.setFarmerId(loginUser.getUserId());

		return "items/itemAdd";

	}

	@PostMapping("/add")
	public String postItemAdd(@ModelAttribute @Validated ItemAddForm form, BindingResult bindingResult,
			Model model, @AuthenticationPrincipal UserDetails userDetails) {

		if (bindingResult.hasErrors()) {

			return getItemAdd(form, model, userDetails);

		}

		//フォームのフィールドをエンティティクラスにコピー
		Items item = new Items();
		//IDはDB側で連番で振られるため、nullでセット
		item.setId(null);
		item.setPrice(form.getPrice());
		item.setFarmerId(form.getFarmerId());

		//最後の文字はカットして登録する
		String formName = form.getName();
		item.setName(itemService.trimFormName(formName));
		itemService.addItem(item);

		return "redirect:/";

	}

}
