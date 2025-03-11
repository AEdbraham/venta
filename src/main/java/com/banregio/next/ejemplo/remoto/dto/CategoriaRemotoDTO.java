package com.banregio.next.ejemplo.remoto.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaRemotoDTO {
	
    private long idCategoria;
    private String nombre;
    private String descripcion;
	

}
