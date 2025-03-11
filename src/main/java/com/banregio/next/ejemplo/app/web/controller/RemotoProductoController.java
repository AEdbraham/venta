package com.banregio.next.ejemplo.app.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banregio.next.ejemplo.app.service.RemotoProductoService;
import com.banregio.next.ejemplo.remoto.dto.ProductoRemotoDTO;
import com.banregio.next.ejemplo.remoto.service.ProductoRemotoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/remoto-producto")
public class RemotoProductoController {
	
	@Autowired
	private RemotoProductoService productoRemotoService;
	
	@ApiOperation(value = "Buscar todos los productos remotos", notes = "Devuelve listado de todos los registros")
	@GetMapping(value = "/")
	public List<ProductoRemotoDTO> findAllProducto(){
		return productoRemotoService.findProducto();
	}

}
