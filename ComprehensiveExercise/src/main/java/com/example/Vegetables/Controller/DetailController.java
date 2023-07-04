package com.example.Vegetables.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Service.ItemService;
import com.example.Vegetables.Form.DetailForm;

@Controller
public class DetailController {

	@Autowired
	private ItemService itemService;

	//詳細画面を返す
	@GetMapping("/detail/{Id}")
	public String getVegetablesDetail(@PathVariable("Id") Integer Id, @ModelAttribute DetailForm detailForm) {

		//主キーで探して商品を1件返す
		itemService.getItemOne(Id);

		return "Vegetables/vegetablesDetail";

	}

	@PostMapping("/detail/update")
	public String updateItem() {

		String string = "hoge";

		return string;
	}

}
