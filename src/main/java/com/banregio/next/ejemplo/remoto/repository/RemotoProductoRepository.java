package com.banregio.next.ejemplo.remoto.repository;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.banregio.next.ejemplo.remoto.dto.ProductoRemotoDTO;

@FeignClient("${producto.uri}")
public interface RemotoProductoRepository {
	

	@GetMapping(value = "/api/producto")
	List <ProductoRemotoDTO> findProducto();

}
