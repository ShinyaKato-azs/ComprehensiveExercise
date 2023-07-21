package com.example.items.controller;

import java.util.List;

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

import com.example.items.form.AddForm;
import com.example.items.ItemAndUsername;
import com.example.items.Items;
import com.example.service.ItemService;
import com.example.service.UserService;
import com.example.user.VUser;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class TableController {

	//配列を廃止
	//	@Autowired
	//	private MakeArray makeArray;
	@Autowired
	private ItemService itemService;

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String getVegetables(Model model, @ModelAttribute AddForm form,
			@AuthenticationPrincipal UserDetails userDetails) {

		/** 廃止した機能 */
		//		List<Items> items = applicationService.makeVegetableArray();
		//		model.addAttribute("Items", items);

		/** ログイン情報からログイン中のユーザーを取得 */
		//【確認用】
		//log.info("ログイン情報の中身:" + userDetails.toString());
		String loginUserMail = userDetails.getUsername();
		VUser loginUser = userService.getLoginUser(loginUserMail);
		model.addAttribute("loginUser", loginUser);

		/** 全てのレコードを取得してthymeleafに渡す */
		List<Items> dbItems = itemService.getItems();
		log.info(dbItems.toString());
		model.addAttribute("dbItems", dbItems);

		/**結合したテーブルから商品情報と農家名を取得*/
		List<ItemAndUsername> ItemAndUsername = itemService.getItemsWithUsername();
		log.info(ItemAndUsername.toString());
		model.addAttribute("itemAndUsername", ItemAndUsername);

		return "items/itemsList";

	}

	@GetMapping("/input")
	public String getVegetablesInput(@ModelAttribute AddForm form, Model model,
			@AuthenticationPrincipal UserDetails userDetails) {

		/** ログイン情報からログイン中のユーザーを取得 */
		String loginUserMail = userDetails.getUsername();
		VUser loginUser = userService.getLoginUser(loginUserMail);
		model.addAttribute("loginUser", loginUser);

		/**AddFormのfarmerIdにログイン中のユーザーのIDをセット*/
		form.setFarmerId(loginUser.getUserId());

		return "items/itemsInput";

	}

	@PostMapping("/add")
	public String postVegetables(@ModelAttribute @Validated AddForm form, BindingResult bindingResult,
			Model model, @AuthenticationPrincipal UserDetails userDetails) {

		if (bindingResult.hasErrors()) {

			return getVegetablesInput(form, model, userDetails);

		}
		log.info(form.toString());

		//formで受け取ったフィールドの値をitemクラスのインスタンスにコピー。
		//modelMapperを使用してコピーしても可
		Items item = new Items();

		//DB側で連番で振られるため、nullでセット
		item.setId(null);
		item.setPrice(form.getPrice());
		item.setFarmerId(form.getFarmerId());

		String formName = form.getName();
		//最後の文字をカットして、itemクラスのフィールドとして登録
		item.setName(itemService.trimFormName(formName));
		//DBに登録
		itemService.addItem(item);

		return "redirect:/";

	}

}
