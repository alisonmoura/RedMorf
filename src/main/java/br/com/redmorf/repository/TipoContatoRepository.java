package br.com.redmorf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.redmorf.model.TipoContato;

@Repository
public interface TipoContatoRepository extends JpaRepository<TipoContato, Integer> {

}
