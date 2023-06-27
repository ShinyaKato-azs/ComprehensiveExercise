package com.example.Vegetables.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Service.ItemServiceImpl;
//import com.example.Service.MakeArray;
import com.example.Vegetables.Items;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class TableController {

	//配列を廃止
	//	@Autowired
	//	private MakeArray makeArray;
	@Autowired
	private ItemServiceImpl itemServiceImpl;

	@GetMapping("/vegetables")
	public String getVegetables(Model model) {

		//		List<Items> items = applicationService.makeVegetableArray();
		//		model.addAttribute("Items", items);

		List<Items> dbItems = itemServiceImpl.getItems();
		log.info(dbItems.toString());
		//モデルに登録してthymeleafに渡す
		model.addAttribute("dbItems", dbItems);

		return "Vegetables/vegetables";

	}

}
