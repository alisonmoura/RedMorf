package br.com.redmorf.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.redmorf.model.Cliente;
import br.com.redmorf.model.Contato;
import br.com.redmorf.repository.ClienteRepository;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@Setter
	@Getter
	private List<Cliente> clientes;
	@Setter
	@Getter
	private Cliente cliente = new Cliente();
	@Setter
	@Getter
	private boolean modoEdicao = false;
	@Setter
	@Getter
	private Contato contato = new Contato();

	@PostConstruct
	public void init() {
		setClientes(clienteRepository.findAll());
	}

	public void salvar() {

		clienteRepository.save(cliente);
		if (!isModoEdicao())
			clientes.add(cliente);
		cliente = new Cliente();
		setModoEdicao(false);
	}

	public void excluir(Cliente cliente) {
		clienteRepository.delete(cliente);
		clientes.remove(cliente);
	}

	public void editar(Cliente cliente) {
		setCliente(cliente);
		setModoEdicao(true);
	}

	public void cancelar() {
		cliente = new Cliente();
		setModoEdicao(false);
	}

	public void adicionarContato() {

		contato.setCliente(cliente);
		contato = new Contato();

	}

	public void excluirContato(Contato contato) {

	}

	public ClienteRepository getClienteRepository() {
		return clienteRepository;
	}

	public void setClienteRepository(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public boolean isModoEdicao() {
		return modoEdicao;
	}

}
