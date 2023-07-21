package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.items.ItemAndUsername;

public interface ItemAndUsenameRepository extends JpaRepository<ItemAndUsername, Integer> {

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
	public List<ItemAndUsername> findItems();

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
	public ItemAndUsername getOneItem(@Param("itemId") Integer itemId);

}
