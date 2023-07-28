package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.user.entity.FarmerDetail;

/** 農家詳細画面のリポジトリ */
public interface FarmerDetailRepository extends JpaRepository<FarmerDetail, String> {

	@Query(value = "select "
			+ "    i.farmer_id "
			+ "    , user_name as farmer_name "
			+ "    , i.name as farmer_items_name "
			+ "from "
			+ "    v_user u "
			+ "    INNER JOIN items as i "
			+ "        ON u.user_id = i.farmer_id "
			+ "where "
			+ "    i.farmer_id = :farmerId ; ", nativeQuery = true)
	/** 農家IDで指定し、農家ID・農家名・取り扱い商品を全件取得 */
	public List<FarmerDetail> getFarmerDetails(@Param("farmerId") Integer farmerId);

}
