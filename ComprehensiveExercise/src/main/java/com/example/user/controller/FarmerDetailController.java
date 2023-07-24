package com.example.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.repository.FarmerDetailRepository;
import com.example.service.UserService;
import com.example.user.FarmerDetail;
import com.example.user.form.FarmerDetailForm;

@Controller
public class FarmerDetailController {

	@Autowired
	UserService userService;
	@Autowired
	FarmerDetailRepository farmerDetailRepo;

	@GetMapping("/detail/farmers/{farmerId}")
	public String getFarmersDetail(@PathVariable("farmerId") Integer farmerId,
			Model model, @ModelAttribute FarmerDetailForm farmerDetailForm) {

		//取り扱い野菜一覧を表示するために、全レコードのリストを渡す
		List<FarmerDetail> farmerDetails = userService.getFarmerDetails(farmerId);
		model.addAttribute("farmerDetails", farmerDetails);

		//農家IDと農家名を渡す
		farmerDetailForm.setFarmerId(farmerId);
		farmerDetailForm.setFarmerName(farmerDetails.get(0).getFarmerName());

		return "/user/farmerDetail";

	}

}
