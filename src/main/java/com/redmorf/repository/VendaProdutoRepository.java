package com.redmorf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redmorf.model.VendaProduto;

@Repository
public interface VendaProdutoRepository extends JpaRepository<VendaProduto, Long>{
	
	
	
	

}
