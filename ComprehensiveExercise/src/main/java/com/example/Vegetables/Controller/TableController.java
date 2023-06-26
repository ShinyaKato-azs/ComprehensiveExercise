package com.example.Vegetables.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Service.ApplicationService;
import com.example.Vegetables.Items;

@Controller
public class TableController {

	@Autowired
	private ApplicationService applicationService;

	@GetMapping("/vegetables")
	public String getVegetables(Model model) {

		List<Items> Items = applicationService.MakeVegetableArray();
		model.addAttribute("Items", Items);

		return "Vegetables/vegetables";

	}

}
