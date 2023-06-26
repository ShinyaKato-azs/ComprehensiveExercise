package com.example.Service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.Vegetables.Items;

@Service
public class ApplicationService {

	public ArrayList<Items> MakeVegetableArray() {

		ArrayList<Items> Items = new ArrayList<>();

		//キャベツ、大根、ニンジンをインスタンス化
		Items Cabbage = new Items();
		Cabbage.setId(1);
		Cabbage.setName("キャベツ");

		Items Radish = new Items();
		Radish.setId(2);
		Radish.setName("大根");

		Items Carrot = new Items();
		Carrot.setId(3);
		Carrot.setName("ニンジン");

		//配列に格納
		Items.add(Cabbage);
		Items.add(Radish);
		Items.add(Carrot);

		return Items;

	}

}
