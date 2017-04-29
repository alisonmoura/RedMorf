package br.com.redmorf.repository;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.redmorf.model.Status;
import br.com.redmorf.model.Venda;

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
		for (Venda v : findAll) {
			System.out.println(v.toString());
		}
	}

}
