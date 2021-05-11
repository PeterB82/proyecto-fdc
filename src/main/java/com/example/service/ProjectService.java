/**
 *  Nombre Clase: ProjectService.java
 * Descripcion: Clase que representa a los servicios que se pueden realizar con los proyectos de la empresa e incluye: listado,
 * eliminar, etc. 
 * Fecha: 11/05/2021
 * Version: 1.0
 * Autor: Jin Mun  **/

package com.example.service;

import java.util.*;
import com.example.model.Project;

public interface ProjectService {

	// Listar proyectos
	public List<Project> findAll();

}
