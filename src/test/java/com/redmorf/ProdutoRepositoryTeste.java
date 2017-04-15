
package com.redmorf;

import java.math.BigDecimal;
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

import com.redmorf.model.Cliente;
import com.redmorf.model.Produto;
import com.redmorf.repository.ProdutoRepository;

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
		produto.setData(new Date());
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
