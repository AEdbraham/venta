package com.banregio.next.ejemplo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

import com.banregio.next.common.NextConfiguration;

/**
 * Clase main que inicia el despliegue del proyecto.
 * La anotación {@link NextConfiguration} permite iniciar en el orden correspondiente 
 * las configuraciones y beans requeridos para el funcionamiento del módulo.
 * 
 * @author ${user}
 * @since ${date}
 */
@SpringBootApplication
@NextConfiguration
public class EjemploApplication {

    public static void main(String[] args) {
        SpringApplication.run(EjemploApplication.class, args);
    }
}
