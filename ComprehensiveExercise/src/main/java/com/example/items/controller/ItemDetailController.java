package com.example.items.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.items.ItemDetail;
import com.example.items.Items;
import com.example.items.form.DetailForm;
import com.example.service.ItemService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ItemDetailController {

	@Autowired
	private ItemService itemService;

	//詳細画面を返す
	@GetMapping("/detail/{itemId}")
	public String getVegetablesDetail(@PathVariable("itemId") Integer itemId, @ModelAttribute DetailForm detailForm) {

		//主キーで探して商品を1件返す
		ItemDetail item = itemService.getItemOneWithUsername(itemId);
		//Formクラスにitemをコピー
		detailForm.setId(itemId);
		detailForm.setName(item.getName());
		detailForm.setPrice(item.getPrice());
		detailForm.setFarmerId(item.getFarmerId());
		detailForm.setFarmerName(item.getFarmerName());

		return "items/itemsDetail";

	}

	//更新処理
	@PostMapping("/detail/{itemId}/update")
	public String updateItem(@ModelAttribute @Validated DetailForm form, BindingResult bindingResult,
			@PathVariable("itemId") Integer itemId) {

		if (bindingResult.hasErrors()) {

			return getVegetablesDetail(itemId, form);

		}

		log.info(form.toString());

		//idが一致する商品を持ってくる
		Items updateItem = itemService.getItemOne(itemId);
		//名前と価格フィールドだけ変更
		updateItem.setName(form.getName());
		updateItem.setPrice(form.getPrice());
		log.info(updateItem.toString());

		//更新
		itemService.updateItemOne(updateItem);

		return "redirect:/";
	}

	//削除処理
	@PostMapping("/detail/{itemId}/delete")
	public String delteItem(@ModelAttribute DetailForm form) {

		//postが正しく機能しているかログで確認
		log.info(form.toString());
		//		削除はIDの管理が面倒なのでコメントアウト（動作確認済み）
		//		itemService.deleteItemOne(form.getId());

		return "redirect:/";

	}

}