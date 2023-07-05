package com.example.Vegetables.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Service.ItemService;
import com.example.Vegetables.Items;
import com.example.Vegetables.Form.DetailForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class DetailController {

	@Autowired
	private ItemService itemService;

	//詳細画面を返す
	@GetMapping("/detail/{itemId}")
	public String getVegetablesDetail(@PathVariable("itemId") Integer itemId, @ModelAttribute DetailForm detailForm) {

		//主キーで探して商品を1件返す
		Items item = itemService.getItemOne(itemId);
		//Formクラスにitemをコピー
		detailForm.setId(itemId);
		detailForm.setName(item.getName());

		return "Vegetables/vegetablesDetail";

	}

	//更新処理
	@PostMapping("/detail/update/{itemId}")
	public String updateItem(@ModelAttribute DetailForm form,
			@PathVariable("itemId") Integer itemId) {

		log.info(form.toString());

		//idが一致する商品を持ってくる
		Items item = itemService.getItemOne(itemId);
		//nameだけを変更
		item.setName(form.getName());
		log.info(item.toString());

		return "redirect:/";
	}

}
