package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ItemsRepository.ItemsRepository;
import com.example.Vegetables.Items;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemsRepository repository;

	@Override
	public List<Items> getItems() {

		return repository.findAll();
	}

	@Transactional
	@Override
	public void addItem(Items item) {

		repository.save(item);

	}

}
