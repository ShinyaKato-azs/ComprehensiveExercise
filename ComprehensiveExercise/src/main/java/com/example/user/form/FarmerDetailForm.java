package com.example.user.form;

import lombok.Data;

@Data
/** 農家詳細画面にデータを渡すためのクラス */
public class FarmerDetailForm {

	/** 農家ID */
	private Integer farmerId;

	/** 農家名 */
	private String farmerName;

}
