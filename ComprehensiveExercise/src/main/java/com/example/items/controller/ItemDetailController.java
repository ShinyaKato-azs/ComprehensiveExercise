package com.example.items.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.items.entity.ItemDetail;
import com.example.items.entity.Items;
import com.example.items.form.ItemDetailForm;
import com.example.service.ItemService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
/** 詳細画面のコントローラー */
public class ItemDetailController {

	@Autowired
	private ItemService itemService;

	/** 商品詳細画面を返す */
	@GetMapping("/detail/{itemId}")
	public String getItemDetail(@PathVariable("itemId") Integer itemId, @ModelAttribute ItemDetailForm form) {

		/*
		 *商品詳細画面では、商品情報に加えて、農家名も表示する
		 *そのため、商品テーブルとユーザーテーブルを結合して詳細情報を取得する
		 */
		ItemDetail item = itemService.getItemOneWithUsername(itemId);

		form.setId(itemId);
		form.setName(item.getName());
		form.setPrice(item.getPrice());
		form.setFarmerId(item.getFarmerId());
		form.setFarmerName(item.getFarmerName());

		return "items/itemDetail";

	}

	/** 商品名・価格の更新処理 */
	@PostMapping("/detail/{itemId}/update")
	public String updateItem(@ModelAttribute @Validated ItemDetailForm form, BindingResult bindingResult,
			@PathVariable("itemId") Integer itemId) {

		if (bindingResult.hasErrors()) {

			return getItemDetail(itemId, form);

		}

		log.info(form.toString());

		/*
		 * フォームから受け取った商品idと一致する商品を持ってくる
		 * 商品IDと農家IDは更新せず、名前と価格フィールドだけを更新する
		 */
		Items updateItem = itemService.getItemOne(itemId);
		updateItem.setName(form.getName());
		updateItem.setPrice(form.getPrice());
		log.info(updateItem.toString());

		itemService.updateItemOne(updateItem);

		return "redirect:/";
	}

	/** 削除処理 */
	@PostMapping("/detail/{itemId}/delete")
	public String delteItem(@ModelAttribute ItemDetailForm form) {

		//postが正しく機能しているかをログで確認
		log.info(form.toString());
		//		削除はIDの管理が面倒なのでコメントアウト中（動作確認済み）
		//		itemService.deleteItemOne(form.getId());

		return "redirect:/";

	}

}
