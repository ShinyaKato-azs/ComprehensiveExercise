package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Vegetables.ItemAndUserJoinedWithFarmerId;

public interface ItemAndUsenameRepository extends JpaRepository<ItemAndUserJoinedWithFarmerId, Integer> {

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
	public List<ItemAndUserJoinedWithFarmerId> findItems();

}
