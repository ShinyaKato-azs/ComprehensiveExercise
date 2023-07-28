package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.user.entity.VUser;

/** ユーザー管理（ログイン・新規登録）のためのリポジトリ */
public interface UserRepository extends JpaRepository<VUser, String> {

	public Optional<VUser> findByUserMail(String userMail);

}
