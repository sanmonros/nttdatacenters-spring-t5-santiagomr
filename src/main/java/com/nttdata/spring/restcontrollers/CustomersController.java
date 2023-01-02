package com.nttdata.spring.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.spring.repository.Customers;
import com.nttdata.spring.services.CustomersManagementServiceI;

/**
 * Clase Principal
 * 
 * @author santiagomr
 *
 */
@RestController
@RequestMapping("/customers")
public class CustomersController {

	@Autowired
	CustomersManagementServiceI customerService;

	/**
	 * Lista de todos los clientes existentes
	 * 
	 * @return
	 */
	@RequestMapping("showCustomers")
	public @ResponseBody List<Customers> showAllCustomers() {
		return customerService.getAllCustomers();
	}

	/**
	 * Añadir un nuevo cliente
	 * 
	 * @param newCustomers
	 */
	@PostMapping
	public void generateCustomers(@ModelAttribute("customers") Customers newCustomers) {
		customerService.insertCustomers(newCustomers);
	}

	/**
	 * Consultar el nombre completo del cliente
	 * 
	 * @param name
	 * @param lastName
	 * @param secondLastName
	 * @return
	 */
	@RequestMapping("searchCustomers")
	public @ResponseBody List<Customers> searchByFullName(@RequestParam String name, @RequestParam String lastName,
			@RequestParam String secondLastName) {
		return customerService.getCustomersByFullName(name, lastName, secondLastName);
	}
}
