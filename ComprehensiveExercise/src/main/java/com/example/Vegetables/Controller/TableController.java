package com.example.Vegetables.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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

	@GetMapping("/")
	public String getVegetables(Model model, @ModelAttribute AddForm form) {

		//		List<Items> items = applicationService.makeVegetableArray();
		//		model.addAttribute("Items", items);

		List<Items> dbItems = itemService.getItems();
		log.info(dbItems.toString());
		//モデルに登録してthymeleafに渡す
		model.addAttribute("dbItems", dbItems);

		return "vegetables/vegetables";

	}

	@GetMapping("/input")
	public String getVegetablesInput(@ModelAttribute AddForm form) {

		return "vegetables/vegetablesInput";

	}

	@PostMapping("/add")
	public String postVegetables(@ModelAttribute @Validated AddForm form, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {

			return getVegetablesInput(form);

		}
		log.info(form.toString());

		//formで受け取ったフィールドの値をitemクラスのインスタンスにコピー。
		//modelMapperを使用してコピーしても可
		Items item = new Items();

		//DB側で連番で振られるため、nullでセット（いらないかも）
		item.setId(null);

		String formName = form.getName();
		//最後の文字をカットして、itemクラスのフィールドとして登録
		item.setName(itemService.trimFormName(formName));
		//DBに登録
		itemService.addItem(item);

		return "redirect:/";

	}

}
