package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.items.entity.ItemList;

/** 商品一覧画面のリポジトリ */
public interface ItemListRepository extends JpaRepository<ItemList, Integer> {

	@Query(value = "select "
			+ "    user_name as farmer_name "
			+ "    , id as item_id "
			+ "    , i.name "
			+ "    , i.price "
			+ "    , i.farmer_id "
			+ "from "
			+ "    v_user u "
			+ "    INNER JOIN items as i "
			+ "        ON u.user_id = i.farmer_id; ", nativeQuery = true)
	public List<ItemList> findItems();

	@Query(value = "select "
			+ "    user_name as farmer_name "
			+ "    , id as item_id "
			+ "    , i.name "
			+ "    , i.price "
			+ "    , i.farmer_id "
			+ "from "
			+ "    v_user u "
			+ "    INNER JOIN items as i "
			+ "        ON u.user_id = i.farmer_id "
			+ "where "
			+ "    i.id = :itemId ; ", nativeQuery = true)
	public ItemList getOneItem(@Param("itemId") Integer itemId);

}
