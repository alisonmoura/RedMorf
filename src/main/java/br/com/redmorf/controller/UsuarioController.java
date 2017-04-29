package br.com.redmorf.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.redmorf.model.Usuario;
import br.com.redmorf.repository.UsuarioRepository;

@Named
@ViewScoped
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	private List<Usuario> usuarios;
	private Usuario usuario = new Usuario();
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

	public void editar(Usuario cliente) {
		setUsuario(cliente);
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

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isModoEdicao() {
		return modoEdicao;
	}

	public void setModoEdicao(boolean modoEdicao) {
		this.modoEdicao = modoEdicao;
	}

}
