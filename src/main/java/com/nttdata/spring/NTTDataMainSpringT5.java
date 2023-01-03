package com.nttdata.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.spring.repository.Customers;
import com.nttdata.spring.services.CustomersManagementServiceI;

/**
 * Quinto - Taller - Spring
 * 
 * @author santiagomr
 *
 */
@SpringBootApplication()
public class NTTDataMainSpringT5 implements CommandLineRunner {

	/** Servicio clientes */
	@Autowired
	private CustomersManagementServiceI customerService;

	/**
	 * Método principal para inicializar nuestra aplicación
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(NTTDataMainSpringT5.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Creación de una base de datos de clientes para consumir los diferentes
		// servicios

		Customers c1 = customerService.generateCustomers("Alba", "Salcedo", "Delgado", "30/12/2000", "44532432C");
		Customers c2 = customerService.generateCustomers("Juan", "Coronado", "Luque", "15/02/1995", "15563412Z");
		Customers c3 = customerService.generateCustomers("Claudia", "Oliva", "Nuñez", "11/08/2001", "33521456F");
		Customers c4 = customerService.generateCustomers("Julia", "Montaño", "Serrano", "06/03/1997", "88512332K");
		Customers c5 = customerService.generateCustomers("Arancha", "Ruíz", "Moreno", "13/03/1992", "63532552L");
		Customers c6 = customerService.generateCustomers("José", "Sánchez", "Pérez", "09/09/2004", "32532546R");

		// Inserción clientes
		customerService.insertCustomers(c1);
		customerService.insertCustomers(c2);
		customerService.insertCustomers(c3);
		customerService.insertCustomers(c4);
		customerService.insertCustomers(c5);
		customerService.insertCustomers(c6);
	}

}
