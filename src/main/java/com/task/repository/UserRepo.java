package com.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.entities.*;

public interface UserRepo extends JpaRepository<User, Integer> {

}
