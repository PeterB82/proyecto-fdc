package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.FakeEmployeeService;
import com.example.demo.service.PositionService;

/**
 * Nombre Clase: EmployeeController.java Descripcin: Clase que recoge los
 * controladores de este proyecto con respecto a los empleados Fecha: 13/05/2021
 * Version: 1.0 Autor: Jin Mun / Francisco Rayo / Rocio Jimenez / Pedro
 * Barrantes
 * 
 **/

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	FakeEmployeeService fakeEmployeeService;

	@Autowired
	PositionService positionService;

	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

	/**
	 * Metodo que lista los empleados en el backoffice
	 * 
	 * @param Model n
	 */

	@GetMapping("/backoffice/equipo")
	public String listEmployee(Model n) {
		log.info("----- Inside TeamList ");
		n.addAttribute("TeamList", employeeService.findAll());

		log.info("-------", employeeService.findAll().toString());
		return "TeamList";
	}

	/**
	 * Metodo que lista los empleados en el frontoffice
	 * 
	 * @param Model n
	 */

	@GetMapping("/equipo")
	public String listEmployeeFront(Model n) {
		log.info("----- Inside TeamList ");
		n.addAttribute("TeamList", employeeService.findAll());
		n.addAttribute("FakeTeamList", fakeEmployeeService.findAll(16));
		log.info("----- Contenido de empl ----------------------" + n.toString());
		return "FrontTeamList";
	}

	/**
	 * Metodo que da de alta a los empleados
	 * 
	 */

	@GetMapping("backoffice/equipo/new")
	public ModelAndView newEmployee() {
		ModelAndView model1 = new ModelAndView("TeamForm");
		model1.addObject("employee", new Employee());
		model1.addObject("cargos", positionService.findAll());
		return model1;
	}

	/**
	 * Metodo para editar los empleados
	 * 
	 * @param Model m, int id
	 */

	@GetMapping("backoffice/equipo/edit")
	public String editEmployee(@RequestParam("idPers") int id, Model m) {
		log.info("------Inside editEmployee");
		m.addAttribute("employee", employeeService.getOne(id));
		m.addAttribute("cargos", positionService.findAll());
		return "TeamForm";
	}

	/**
	 * Metodo para borrar los empleados
	 * 
	 * @param int id
	 */

	@GetMapping("backoffice/equipo/delete")
	public ModelAndView deleteEmployee(@RequestParam("idPers") int id) {
		log.info("----- Inside deleteEmployee");
		employeeService.deleteById(id);
		return new ModelAndView("redirect:/backoffice/equipo/");
	}

	/**
	 * Metodo guarda a los empleados (nuevos o editados)
	 * 
	 * @param Employee employee
	 */

	@PostMapping("backoffice/equipo/save")
	public ModelAndView saveEmployee(Employee employee) {
		log.info("----- Inside TeamForm");
		log.info("----- objeto Employee" + employee);
		employeeService.save(employee);
		return new ModelAndView("redirect:/backoffice/equipo/");
	}

}
