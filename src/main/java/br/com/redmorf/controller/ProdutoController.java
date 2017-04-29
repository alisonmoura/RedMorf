package br.com.redmorf.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.redmorf.model.Produto;
import br.com.redmorf.model.Usuario;
import br.com.redmorf.repository.ProdutoRepository;
import br.com.redmorf.repository.UsuarioRepository;

@Named
@ViewScoped
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	private List<Produto> produtos;
	private Produto produto = new Produto();
	private boolean modoEdicao = false;

	@PostConstruct
	public void init() {
		setProdutos(produtoRepository.findAll());
	}

	public void salvar() {
		produtoRepository.save(produto);
		if (!isModoEdicao())
			produtos.add(produto);
		produto = new Produto();
		setModoEdicao(false);
	}

	public void excluir(Produto produto) {
		produtoRepository.delete(produto);
		produtos.remove(produto);
	}

	public void editar(Produto produto) {
		setProduto(produto);
		setModoEdicao(true);
	}

	public void cancelar() {
		produto = new Produto();
		setModoEdicao(false);
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public boolean isModoEdicao() {
		return modoEdicao;
	}

	public void setModoEdicao(boolean modoEdicao) {
		this.modoEdicao = modoEdicao;
	}

}
