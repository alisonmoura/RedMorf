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

import br.com.redmorf.model.Perfil;
import br.com.redmorf.model.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest
//@DataJpaTest
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2, replace = Replace.ANY)
public class UsuarioRepositoryTeste {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Test
	public void deveSalvar() {
		Usuario usuario = new Usuario();
		usuario.setNome("Admin");
		usuario.setLogin("admin");
		usuario.setSenha("123");
		usuario.setPerfil(Perfil.ADMIN);

		usuarioRepository.save(usuario);

		List<Usuario> findAll = usuarioRepository.findAll();
		for (Usuario usu : findAll) {
			System.out.println(usu);
		}
	}

}
