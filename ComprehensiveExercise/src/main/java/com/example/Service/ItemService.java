package com.example.Service;

import java.util.List;

import com.example.Vegetables.ItemAndUsername;
import com.example.Vegetables.Items;

public interface ItemService {

	//一覧表示
	public List<Items> getItems();

	//登録
	public void addItem(Items item);

	//登録時の文字カット機能
	public String trimFormName(String formName);

	//商品取得（1件）
	public Items getItemOne(Integer itemId);

	//商品＋農家名取得（1件）
	public ItemAndUsername getItemOneWithUsername(Integer ItemId);

	//商品更新
	public void updateItemOne(Items item);

	//商品削除
	public void deleteItemOne(Integer itemId);

	//農家名とともに商品一覧を取得
	public List<ItemAndUsername> getItemsWithUsername();

}
