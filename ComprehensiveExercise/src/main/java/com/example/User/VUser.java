package com.example.User;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Component
@Table(name = "v_user")
public class VUser {
	@Id
	private String userId;
	private String password;

}
