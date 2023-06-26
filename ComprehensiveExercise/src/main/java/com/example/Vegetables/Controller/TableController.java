package com.example.Vegetables.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Service.ApplicationService;
import com.example.Service.ItemServiceImpl;
import com.example.Vegetables.Items;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class TableController {

	@Autowired
	private ApplicationService applicationService;
	@Autowired
	private ItemServiceImpl itemServiceImpl;

	@GetMapping("/vegetables")
	public String getVegetables(Model model) {

		List<Items> Items = applicationService.MakeVegetableArray();
		model.addAttribute("Items", Items);

		List<Items> DbItems = itemServiceImpl.getItems();
		log.info(DbItems.toString());

		return "Vegetables/vegetables";

	}

}
