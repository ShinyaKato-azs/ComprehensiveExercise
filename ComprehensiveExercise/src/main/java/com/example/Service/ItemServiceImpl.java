package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
