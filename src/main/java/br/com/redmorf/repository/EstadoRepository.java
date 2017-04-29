package br.com.redmorf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.redmorf.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}
