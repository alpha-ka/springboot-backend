package com.springbootapp.springboot.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
 
import com.springbootapp.springboot.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query(value = "SELECT * FROM Users where status='Active'", 
			nativeQuery = true)
	List<User> findAllActiveUsers(); 
	//   @Procedure(name="UsersReport")
	
	  
	 @Query(value = "{call sp_Users()}", nativeQuery = true)
	List<User> usersReport(); 
			 
	

}
