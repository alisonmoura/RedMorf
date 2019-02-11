package br.com.redmorf.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.redmorf.model.Usuario;
import br.com.redmorf.repository.UsuarioRepository;

import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Getter
	@Setter
	private List<Usuario> usuarios;
	
	@Getter
	@Setter
	private Usuario usuario = new Usuario();
	
	@Getter
	@Setter
	private boolean modoEdicao = false;

	@PostConstruct
	public void init() {
		setUsuarios(usuarioRepository.findAll());
	}

	public void salvar() {
		usuarioRepository.save(usuario);
		if (!isModoEdicao())
			usuarios.add(usuario);
		usuario = new Usuario();
		setModoEdicao(false);
	}

	public void excluir(Usuario usuario) {
		usuarioRepository.delete(usuario);
		usuarios.remove(usuario);
	}

	public void editar(Usuario usuario) {
		setUsuario(usuario);
		setModoEdicao(true);
	}

	public void cancelar() {
		usuario = new Usuario();
		setModoEdicao(false);
	}

	public UsuarioRepository getUsuarioRepository() {
		return usuarioRepository;
	}

	public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public boolean isModoEdicao() {
		return modoEdicao;
	}

}
