package com.example.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Vegetables.Items;

@Service
public interface ItemService {

	public List<Items> getItems();

}
