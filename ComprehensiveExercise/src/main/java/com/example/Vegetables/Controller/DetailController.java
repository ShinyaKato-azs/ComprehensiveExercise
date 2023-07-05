package com.example.Vegetables.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
	public String updateItem(@ModelAttribute @Validated DetailForm form, BindingResult bindingResult,
			@PathVariable("itemId") Integer itemId) {

		if (bindingResult.hasErrors()) {

			return getVegetablesDetail(itemId, form);

		}

		log.info(form.toString());

		//idが一致する商品を持ってくる
		Items updateItem = itemService.getItemOne(itemId);
		//名前フィールドだけ変更
		updateItem.setName(form.getName());
		log.info(updateItem.toString());

		//更新
		itemService.updateItemOne(updateItem);

		return "redirect:/";
	}

	//削除処理
	@PostMapping("/detail/delete/{itemId}")
	public String delteItem() {

		return "redirect:/";

	}

}
