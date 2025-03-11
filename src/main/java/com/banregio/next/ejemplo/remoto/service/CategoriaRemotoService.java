package com.banregio.next.ejemplo.remoto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banregio.next.base.exception.NextError500;
import com.banregio.next.base.feign.exception.NextFeignExceptionNoOpenCircuit;
import com.banregio.next.ejemplo.app.service.RemotoCategoriaService;
import com.banregio.next.ejemplo.remoto.dto.CategoriaRemotoDTO;
import com.banregio.next.ejemplo.remoto.repository.RemotoCategoriaRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategoriaRemotoService {
	
	@Autowired
	private RemotoCategoriaRepository categoriaRemotoService;
	
	@HystrixCommand(fallbackMethod = "callFindCategoriaFallback", ignoreExceptions= {NextFeignExceptionNoOpenCircuit.class})
	public List <CategoriaRemotoDTO> findCategoria(){
		return categoriaRemotoService.findCategoria();
	}
	
	protected List<CategoriaRemotoDTO> callFindCategoriaFallback(Throwable e){
		
		log.error("callFindCategoriaFallback error al buscar categoria", e);
		throw new NextError500(e.getCause() !=null ? e.getCause().getMessage() : e.getMessage());
	}

}
