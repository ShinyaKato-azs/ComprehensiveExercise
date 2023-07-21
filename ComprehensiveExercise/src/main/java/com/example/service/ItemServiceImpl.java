package com.example.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.items.ItemList;
import com.example.items.Items;
import com.example.repository.ItemListRepository;
import com.example.repository.ItemsRepository;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemsRepository repository;
	@Autowired
	private ItemListRepository itemAndUsernameRepository;

	//一覧取得機能
	@Override
	public List<Items> getItems() {

		List<Items> SortItems = repository.findAll();

		Collections.sort(SortItems, (x, y) -> x.getId() - y.getId());

		return SortItems;

	}

	//登録機能
	@Transactional
	@Override
	public void addItem(Items item) {

		repository.save(item);

	}

	//1文字削除する機能
	@Override
	public String trimFormName(String formName) {

		//引数が0文字だったらエラー
		if (formName.length() == 0) {
			throw new IllegalArgumentException("文字列が不正です");
		}

		//文字列の長さを特定して、1文字分を引く
		int endCharInt = formName.length() - 1;

		//1文字少ない長さでトリミング
		String trimmedFormName = formName.substring(0, endCharInt);

		return trimmedFormName;

	}

	//商品取得（1件）
	@Override
	public Items getItemOne(Integer itemId) {

		Optional<Items> option = repository.findById(itemId);
		Items item = option.orElse(null);

		return item;

	}

	//商品＋農家名取得（1件）
	@Override
	public ItemList getItemOneWithUsername(Integer ItemId) {

		ItemList itemAndUsername = itemAndUsernameRepository.getOneItem(ItemId);

		return itemAndUsername;

	}

	//商品更新
	@Override
	public void updateItemOne(Items item) {

		repository.save(item);

	}

	//商品削除
	@Override
	public void deleteItemOne(Integer itemId) {

		repository.deleteById(itemId);

	}

	//農家名とともに商品一覧を取得
	@Override
	public List<ItemList> getItemsWithUsername() {

		List<ItemList> SortItems = itemAndUsernameRepository.findItems();

		Collections.sort(SortItems, (x, y) -> x.getItemId() - y.getItemId());

		return SortItems;

	}

}
