package com.example.Service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.Vegetables.Items;

@Service
public class ApplicationService {

	public ArrayList<Items> makeVegetableArray() {

		ArrayList<Items> items = new ArrayList<>();

		//キャベツ、大根、ニンジンをインスタンス化
		Items cabbage = new Items();
		cabbage.setId(1);
		cabbage.setName("キャベツ");

		Items radish = new Items();
		radish.setId(2);
		radish.setName("大根");

		Items carrot = new Items();
		carrot.setId(3);
		carrot.setName("ニンジン");

		//配列に格納
		items.add(cabbage);
		items.add(radish);
		items.add(carrot);

		return items;

	}

}
