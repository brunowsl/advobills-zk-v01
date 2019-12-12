package br.com.application.advobillszkv01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.application.advobillszkv01.model.Apartment;


/**
 * ApartmentRepository
 */
public interface ApartmentRepository extends JpaRepository<Apartment, Long> {

}