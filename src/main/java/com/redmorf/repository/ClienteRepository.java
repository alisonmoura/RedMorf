package com.redmorf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redmorf.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}

