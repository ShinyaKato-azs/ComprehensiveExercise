package com.example.Vegetables.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.Service.ItemService;

@Controller
public class DetailController {

	@Autowired
	private ItemService itemService;

	//詳細画面を返す
	@GetMapping("/detail/{Id}")
	public String getVegetablesDetail(@PathVariable("Id") Integer Id) {

		//主キーで探して商品を1件返す
		itemService.getItemOne(Id);

		return "Vegetables/vegetablesDetail";

	}

}
