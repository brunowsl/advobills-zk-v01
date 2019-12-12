package br.com.application.advobillszkv01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.application.advobillszkv01.model.Tenant;

public interface TenantRepository extends JpaRepository<Tenant, Long> {

}