package com.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.entities.*;

public interface PayrollRepo extends JpaRepository<Payroll,Integer> {

}
