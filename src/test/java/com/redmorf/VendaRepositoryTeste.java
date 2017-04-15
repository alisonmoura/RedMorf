package com.redmorf;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.redmorf.model.Status;
import com.redmorf.model.Usuario;
import com.redmorf.model.Venda;
import com.redmorf.repository.VendaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2, replace = Replace.ANY)
public class VendaRepositoryTeste {
	
	@Autowired
	VendaRepository vendaRepository;

	@Test
	public void deveSalvar() {
		
		Venda venda = new Venda();
		venda.setStatus(Status.CONCLUIDO);
		venda.setDataVenda(new Date());

		vendaRepository.save(venda);

		List<Venda> findAll = vendaRepository.findAll();
		for (Venda v: findAll) {
			System.out.println(v.toString());
		}
	}

}
