package com.banregio.next.ejemplo.remoto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banregio.next.base.exception.NextError500;
import com.banregio.next.base.feign.exception.NextFeignExceptionNoOpenCircuit;
import com.banregio.next.ejemplo.app.service.RemotoProductoService;
import com.banregio.next.ejemplo.remoto.dto.CategoriaRemotoDTO;
import com.banregio.next.ejemplo.remoto.dto.ProductoRemotoDTO;
import com.banregio.next.ejemplo.remoto.repository.RemotoProductoRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductoRemotoService {
	
	@Autowired
	private RemotoProductoRepository productoRemotoService;
	
	@HystrixCommand(fallbackMethod = "callFindProductoFallback", ignoreExceptions= {NextFeignExceptionNoOpenCircuit.class})
	public List<ProductoRemotoDTO> findProducto(){
		return productoRemotoService.findProducto();
	}
	
	protected List<ProductoRemotoDTO> callFindProductoFallback(Throwable e){
		
		log.error("callFindCategoriaFallback error al buscar producto", e);
		throw new NextError500(e.getCause() !=null ? e.getCause().getMessage() : e.getMessage());
	}

}
