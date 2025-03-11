package com.banregio.next.ejemplo.app.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banregio.next.ejemplo.app.service.RemotoCategoriaService;
import com.banregio.next.ejemplo.remoto.dto.CategoriaRemotoDTO;
import com.banregio.next.ejemplo.remoto.service.CategoriaRemotoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/remoto-categoria")
public class RemotoCategoriaController {

	@Autowired
	private RemotoCategoriaService categoriaRemotoService;
	
	@ApiOperation(value = "Buscar todas las categorias remotas", notes = "Devuelve listado de todos los registros")
	@GetMapping(value = "/")
	public List<CategoriaRemotoDTO> findAllCategoria(){
		return categoriaRemotoService.findCategoria();
	}
		
}
