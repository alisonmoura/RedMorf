package br.com.redmorf.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.redmorf.model.TipoContato;
import br.com.redmorf.repository.TipoContatoRepository;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class TipoContatoController {

	@Autowired
	private TipoContatoRepository tipoContatoRepository;

	@Getter
	@Setter
	private List<TipoContato> tipoContatos;

	@PostConstruct
	public void init() {
		setTipoContatos(tipoContatoRepository.findAll());
	}

}
