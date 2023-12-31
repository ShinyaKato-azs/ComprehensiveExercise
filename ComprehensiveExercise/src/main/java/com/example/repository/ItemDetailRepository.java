package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.items.entity.ItemDetail;

/** 商品詳細画面のリポジトリ */
public interface ItemDetailRepository extends JpaRepository<ItemDetail, Integer> {

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
	/** 
	 * 商品IDで指定する
	 * ItemDetailエンティティのフィールド要素を取得 
	 */
	public ItemDetail getItemOne(@Param("itemId") Integer itemId);

}
