package com.nttdata.spring.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
@RequestMapping(path = "/customers")
public class CustomersController {

	/** Servicio cliente*/
	@Autowired
	CustomersManagementServiceI customerService;

	/**
	 * Añadir un nuevo cliente
	 * 
	 * @param newCustomers
	 */
	@GetMapping(value = "/newCustomers")
	public void generateCustomers(@ModelAttribute("customers") Customers newCustomers) {
		customerService.insertCustomers(newCustomers);
	}

	/**
	 * Lista de todos los clientes existentes
	 * 
	 * @return
	 */
	@GetMapping(value = "/showCustomers")
	public @ResponseBody List<Customers> showAll() {
		return customerService.getAllCustomers();
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

	/**
	 * Consultar por el Id del cliente
	 * 
	 * @param customerId
	 * @return
	 */
	@RequestMapping("searchCustomersById")
	public @ResponseBody Customers searchById(@RequestParam Long customerId) {
		return customerService.getCustomersById(customerId);
	}

	/**
	 * Borrar cliente por Id introducido
	 * 
	 * @param customerId
	 */
	@RequestMapping("deleteCustomersById")
	public @ResponseBody void deleteById(@RequestParam Long customerId) {
		customerService.deleteCustomersById(customerId);
		System.out.println("Éxito en el borrado");
	}

}
