package com.banregio.next.ejemplo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banregio.next.ejemplo.remoto.dto.CategoriaRemotoDTO;
import com.banregio.next.ejemplo.remoto.service.CategoriaRemotoService;

@Service
public class RemotoCategoriaService {

	@Autowired
	private CategoriaRemotoService categoriaRemotoService;
	
	public List<CategoriaRemotoDTO> findCategoria(){
		return categoriaRemotoService.findCategoria();
	}
	
}
