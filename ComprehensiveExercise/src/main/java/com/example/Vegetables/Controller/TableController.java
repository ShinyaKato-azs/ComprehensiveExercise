package com.example.Vegetables.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TableController {

	@GetMapping("/vegetables")
	public String getVegetables() {

		return "Vegetables/vegetables";
	}

}
