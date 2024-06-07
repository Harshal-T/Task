package com.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//import com.dabbawallah.entities.CoustumerData;
import com.task.entities.*;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	@Query("Select c from Customer as c")
	public List<Customer> getAllcutomers();

}
