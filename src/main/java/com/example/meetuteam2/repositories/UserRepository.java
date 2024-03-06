package com.example.meetuteam2.repositories;

import com.example.meetuteam2.entities.Meets;
import com.example.meetuteam2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
