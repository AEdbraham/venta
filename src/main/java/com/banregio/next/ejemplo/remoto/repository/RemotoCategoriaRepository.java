package com.banregio.next.ejemplo.remoto.repository;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.banregio.next.ejemplo.remoto.dto.CategoriaRemotoDTO;

@FeignClient("${categoria.uri}")
public interface RemotoCategoriaRepository {
	
	@GetMapping(value = "/api/categoria")
	List <CategoriaRemotoDTO> findCategoria();

}
