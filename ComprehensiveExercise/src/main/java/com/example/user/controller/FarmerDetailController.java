package com.example.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FarmerDetailController {

	@GetMapping("/detail/farmers/{farmerId}")
	public String getFarmersDetail(@PathVariable("farmerId") Integer farmerId) {

		return "/user/farmerDetail";

	}

}
