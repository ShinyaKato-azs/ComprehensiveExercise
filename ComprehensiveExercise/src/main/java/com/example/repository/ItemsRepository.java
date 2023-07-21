package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.items.Items;

public interface ItemsRepository extends JpaRepository<Items, Integer> {

}
