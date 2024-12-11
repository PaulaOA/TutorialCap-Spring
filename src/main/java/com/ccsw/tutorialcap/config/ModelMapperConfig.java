package com.ccsw.tutorialcap.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Esta configuración nos permitirá luego hacer transformaciones entre objetos de forma muy sencilla
@Configuration
public class ModelMapperConfig {
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
	//Controlador: En esta capa es donde se exponen las operaciones que queremos publicar y que el cliente puede consumir.
	//Lógica: Es la capa intermedia que da soporte a las operaciones que están expuestas y ejecutan toda la lógica de negocio de la aplicación.
	

}
