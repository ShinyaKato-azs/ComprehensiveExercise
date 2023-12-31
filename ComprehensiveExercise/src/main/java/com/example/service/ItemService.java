package com.example.service;

import java.util.List;

import com.example.items.entity.ItemDetail;
import com.example.items.entity.ItemList;
import com.example.items.entity.Items;

/** 商品の取得・更新・削除のためのサービスインターフェース */
public interface ItemService {

	/** 商品一覧表示 */
	public List<Items> getItems();

	/** 商品登録 */
	public void addItem(Items item);

	/** 商品登録時の文字カット機能 */
	public String trimFormName(String formName);

	/** 商品取得（1件） */
	public Items getItemOne(Integer itemId);

	/** 商品＋農家名取得（1件） */
	public ItemDetail getItemOneWithUsername(Integer ItemId);

	/** 商品更新 */
	public void updateItemOne(Items item);

	/** 商品削除 */
	public void deleteItemOne(Integer itemId);

	/** 農家名とともに商品一覧を取得 */
	public List<ItemList> getItemsWithUsername();

}
