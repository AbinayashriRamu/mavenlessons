package com.chainsys.mavenlessons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

//import com.chainsys.mavenlessons.entity.Passport;
import com.chainsys.mavenlessons.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	User findById(int id);
//	Passport findByPassportId(int id);
	List<User> findAll();
	User save(User user);
	void deleteById(int id);
	
	
//	@Query("select u from User u where u.id=1?")//?1,?2,?3 positioned parameters  
//	User getUser(int uid);//ex:JPQL
//	@Query(value="select* from users u where u.USER_ID=?1" ,nativeQuery=true)
//	User getUserNativeSQL(int uid);//ex:of native query 
//	//by default @query will execute only select statement
//	//to execute insert,update,delete statement @query should be marked as @modifyed
//	@Modifying
//	@Query("update User u set u.name=?2, u.city=?3 where u.id=?1")
//	void modifyUser(int id,String name,String city);
//	
//	//@Param
//	@Query("select u from User u where u.city= :ucity")//named parameters
//	List<User>getUsersFromCity(@Param("ucity")String city);
	
}
// JPQL(java persistance query language)query on pojo entity classes
//native SQL Queries
 
