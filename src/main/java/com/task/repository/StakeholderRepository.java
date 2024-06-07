package com.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.task.entities.Stakeholder;

public interface StakeholderRepository extends JpaRepository<Stakeholder, Integer> {
	
	@Query("select s from Stakeholder s where s.email=:email")
	public Stakeholder getUserByUserName(@Param("email") String email);

}
