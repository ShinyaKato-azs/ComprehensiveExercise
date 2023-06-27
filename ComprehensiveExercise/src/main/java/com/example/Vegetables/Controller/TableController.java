package com.example.Vegetables.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Service.ItemService;
//import com.example.Service.MakeArray;
import com.example.Vegetables.Items;
import com.example.Vegetables.Form.AddForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class TableController {

	//配列を廃止
	//	@Autowired
	//	private MakeArray makeArray;
	@Autowired
	private ItemService itemService;

	@GetMapping("/vegetables")
	public String getVegetables(Model model, @ModelAttribute AddForm form) {

		//		List<Items> items = applicationService.makeVegetableArray();
		//		model.addAttribute("Items", items);

		List<Items> dbItems = itemService.getItems();
		log.info(dbItems.toString());
		//モデルに登録してthymeleafに渡す
		model.addAttribute("dbItems", dbItems);

		return "Vegetables/vegetables";

	}

	@PostMapping("/vegetables")
	public String postVegetables(AddForm form) {

		log.info(form.toString());

		//formで受け取ったフィールドの値をitemクラスのインスタンスにコピー。
		//modelMapperを使用してコピーしても可
		Items item = new Items();
		item.setId(form.getId());
		item.setName(form.getName());
		//DBに登録
		itemService.addItem(item);

		return "redirect:/vegetables";

	}

}
