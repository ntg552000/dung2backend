package com.dung2_backend.repository;

import com.dung2_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Query(value = "select * from User where account = ?1", nativeQuery = true)
    Collection<User> findByAccount(String account);


}
