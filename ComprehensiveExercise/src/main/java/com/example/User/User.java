package com.example.User;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "v_user")
public class User {
	@Id
	private Integer userId;
	private String password;

}
