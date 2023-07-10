package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.User.VUser;

public interface UserRepository extends JpaRepository<VUser, String> {

}
