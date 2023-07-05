package com.example.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ItemsRepository.ItemsRepository;
import com.example.Vegetables.Items;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemsRepository repository;

	//一覧取得機能
	@Override
	public List<Items> getItems() {

		return repository.findAll();
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

	//商品更新
	@Override
	public void updateItemOne(Items item) {

		repository.save(item);

	}

}
