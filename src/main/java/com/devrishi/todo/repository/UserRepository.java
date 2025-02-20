package com.devrishi.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devrishi.todo.contract.UserDTO;
import com.devrishi.todo.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	
	@Query("SELECT new com.devrishi.todo.contract.UserDTO(b.txnId ,b.name , b.email , b.age) FROM UserEntity b where b.txnId =?1")
	UserDTO findByTxnId(int userId);
}
