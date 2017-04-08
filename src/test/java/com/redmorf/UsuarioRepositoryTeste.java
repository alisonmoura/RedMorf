package com.redmorf;

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

import com.redmorf.model.Usuario;
import com.redmorf.repository.UsuarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2, replace = Replace.ANY)
public class UsuarioRepositoryTeste {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Test
	public void testeSalvar() {
		Usuario usuario = new Usuario();
		usuario.setNome("Maria da Silva");
		usuario.setEmail("maria@gmail.com");
		usuario.setSenha("321");

		usuarioRepository.save(usuario);

		List<Usuario> findAll = usuarioRepository.findAll();
		for (Usuario usu : findAll) {
			System.out.println(usu.toString());
		}
	}

}
