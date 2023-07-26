package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.items.entity.Items;

public interface ItemsRepository extends JpaRepository<Items, Integer> {

}
