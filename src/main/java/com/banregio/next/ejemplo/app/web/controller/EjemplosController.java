package com.banregio.next.ejemplo.app.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banregio.next.ejemplo.app.domain.entity.Ejemplo;
import com.banregio.next.ejemplo.app.service.EjemplosService;
import com.banregio.next.ejemplo.remoto.dto.CategoriaRemotoDTO;
import com.banregio.next.ejemplo.remoto.dto.ProductoRemotoDTO;
import com.banregio.next.ejemplo.remoto.service.CategoriaRemotoService;
import com.banregio.next.ejemplo.remoto.service.ProductoRemotoService;
import com.banregio.next.postgre.web.controller.PostgreController;

import io.swagger.annotations.ApiOperation;

/**
 * Ejemplo de un controlador de recursos CRUD
 * @author ${user}
 * @since ${date}
 */
@RestController
@RequestMapping(value = "/ejemplos")
public class EjemplosController extends PostgreController<Ejemplo> {
	private EjemplosService service;
	
	
	@Autowired
	public EjemplosController(EjemplosService service) {
		super(service);
		this.service = service;
	}

	@ApiOperation(value = "Buscar todos", notes = "Devuelve un listado de todos los registros.")
	@GetMapping()
	public List<Ejemplo> buscarTodos() {
		return super.findAll();
	}

	@ApiOperation(value = "Buscar por Id", notes = "Devuelve un registro por id.")
	@GetMapping(value = "/{id}")
	public Ejemplo buscarPorId(@PathVariable Long id) {
		return super.findById(id);
	}
	
	@ApiOperation(value = "Buscar Usuario", notes = "Devuelve un usuario ligado al ejemplo.")
	@GetMapping(value = "/{id}/usuarios/{brm}")
	public Ejemplo buscarPorUsuario(@PathVariable Long id, @PathVariable String brm) {
		return service.findUsuario(id,brm);
	}

	@ApiOperation(value = "Crear un registro", notes = "Genera un nuevo registro.")
	@PostMapping
	public Ejemplo guardar(@RequestBody Ejemplo instance) {
		return super.save(instance);
	}

	@ApiOperation(value = "Actualizar todos los campos", notes = "Actualiza todos los campos de un registro.")
	@PutMapping(value = "/{id}")
	public Ejemplo actualizar(@RequestBody Ejemplo instance, @PathVariable Long id) {
		return super.update(instance, id);
	}

	@ApiOperation(value = "Actualizar campos especificos", notes = "Actualiza solo los campos espec\u00EDficos de un registro.")
	@PatchMapping(value = "/{id}")
	public Ejemplo actualizarParcial(@RequestBody Ejemplo instance, @PathVariable Long id) {
		return super.merge(instance, id);
	}

	@ApiOperation(value = "Borrar por id", notes = "Borra un registro por el id especificado.")
	@DeleteMapping("/{id}")
	public void borrar(@PathVariable Long id) {
		super.delete(id);
	}
	
	
}