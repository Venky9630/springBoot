package com.example.demo.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserDetails;

@Repository
public interface UserRepository extends CrudRepository<UserDetails,String>{

	Optional<UserDetails> findById(int n);

	public void delete(int id);

}
