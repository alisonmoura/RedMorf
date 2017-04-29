package br.com.redmorf.repository;

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

import br.com.redmorf.model.Cliente;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2, replace = Replace.ANY)

public class ClienteRepositoryTeste {
	@Autowired
	ClienteRepository clienteRepository;

	@Test
	public void deveSalvar() {
		Cliente cliente = new Cliente();
		cliente.setNome("joao silvino");
		cliente.setEmail("joao@gmail.com");
		cliente.setTelefone("33445566");
		cliente.setCelular("999887766");
		

		clienteRepository.save(cliente);

		List<Cliente> findAll = clienteRepository.findAll();
		for (Cliente cli : findAll) {
			System.out.println(cli.toString());
		}
	}
}
