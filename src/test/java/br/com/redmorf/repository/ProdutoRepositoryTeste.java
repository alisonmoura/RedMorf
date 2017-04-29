
package br.com.redmorf.repository;

import java.math.BigDecimal;
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

import br.com.redmorf.model.Produto;


@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2, replace = Replace.ANY)
public class ProdutoRepositoryTeste {

	@Autowired
	ProdutoRepository produtoRepository;

	@Test
	public void deveSalvar() {
		Produto produto = new Produto();
		produto.setDescricao("de boa qualidade");
		produto.setNome("cadeira");
		produto.setPreco(new BigDecimal(100));

		produtoRepository.save(produto);

		List<Produto> findAll = produtoRepository.findAll();
		for (Produto pro : findAll) {
			System.out.println(pro.toString());
		}

	}
}
