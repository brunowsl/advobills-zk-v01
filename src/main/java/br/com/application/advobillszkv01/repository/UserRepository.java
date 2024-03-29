package br.com.application.advobillszkv01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.application.advobillszkv01.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByEmail(String email);
	

}