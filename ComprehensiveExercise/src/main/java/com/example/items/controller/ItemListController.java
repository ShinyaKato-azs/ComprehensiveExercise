package com.example.items.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.items.entity.ItemList;
import com.example.items.entity.Items;
import com.example.items.form.ItemAddForm;
import com.example.service.ItemService;
import com.example.service.UserService;
import com.example.user.entity.VUser;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
/** 商品一覧画面のコントローラー */
public class ItemListController {

	@Autowired
	private ItemService itemService;

	@Autowired
	private UserService userService;

	/** 商品一覧画面を返す */
	@GetMapping("/")
	public String getItemsList(Model model, @ModelAttribute ItemAddForm form,
			@AuthenticationPrincipal UserDetails userDetails) {

		/*
		 * ログイン情報がこのメソッドに正しく引き渡されているか確認
		 * log.info("ログイン情報の中身:" + userDetails.toString());
		 */

		//ログイン情報のユーザーネーム（メールアドレス）からログイン中のユーザーを取得
		String loginUserMail = userDetails.getUsername();
		VUser loginUser = userService.getLoginUser(loginUserMail);
		model.addAttribute("loginUser", loginUser);

		//商品情報を全件取得
		List<Items> dbItems = itemService.getItems();
		log.info(dbItems.toString());
		model.addAttribute("dbItems", dbItems);

		//機能拡張：商品情報＋その商品を登録した農家名を全件取得
		List<ItemList> ItemAndUsername = itemService.getItemsWithUsername();
		log.info(ItemAndUsername.toString());
		model.addAttribute("itemAndUsername", ItemAndUsername);

		return "items/itemsList";

	}

}
