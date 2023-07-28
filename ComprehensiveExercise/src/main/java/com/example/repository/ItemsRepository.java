package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.items.entity.Items;

/** 商品管理（追加・更新・削除）のためのリポジトリ */
public interface ItemsRepository extends JpaRepository<Items, Integer> {

}
