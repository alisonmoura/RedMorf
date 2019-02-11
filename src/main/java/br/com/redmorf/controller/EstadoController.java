package br.com.redmorf.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.redmorf.model.Estado;
import br.com.redmorf.repository.EstadoRepository;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class EstadoController {

	@Autowired
	private EstadoRepository estadoRepository;
	@Getter
	@Setter
	private List<Estado> estados;

	@PostConstruct
	public void init() {
		setEstados(estadoRepository.findAll());
	}
	
}
