package br.com.shopbra.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.shopbra.entity.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	
	
	Optional<User> getUserById(String id);
	
	
}
