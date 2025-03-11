package com.banregio.next.ejemplo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banregio.next.ejemplo.remoto.dto.ProductoRemotoDTO;
import com.banregio.next.ejemplo.remoto.service.ProductoRemotoService;

@Service
public class RemotoProductoService {

	@Autowired 
	private ProductoRemotoService productoRemotoService;
	
	public List<ProductoRemotoDTO> findProducto(){
		return productoRemotoService.findProducto();
	}
	
}
