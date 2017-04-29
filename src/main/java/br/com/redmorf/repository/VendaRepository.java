package br.com.redmorf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.redmorf.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {
	
	

}
