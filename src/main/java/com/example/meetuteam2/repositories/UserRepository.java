package com.example.meetuteam2.repositories;

import com.example.meetuteam2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE recordStatus = 'A'")
    List<User> findAllActiveUsers();
    @Query("SELECT u FROM User u WHERE recordStatus = 'A' AND id = ?1")
    List<User> findActiveUserById(Long id);
}
