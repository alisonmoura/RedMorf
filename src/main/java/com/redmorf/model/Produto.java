package com.redmorf.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_produto")
	@SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto", initialValue = 1, allocationSize = 50)
	private Long id;
	@Column(nullable = false)
	String nome;
	@Column(nullable = false, unique = true)
	String descricao;

	@Column(nullable = false)
	@Digits(integer=2, fraction=5)
	BigDecimal preco;
	@Column(nullable = false)
	Date data;

}
