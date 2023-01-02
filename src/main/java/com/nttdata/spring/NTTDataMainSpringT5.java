package com.nttdata.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.spring.services.CustomersManagementServiceI;

/**
 * Quinto - Taller - Spring
 * 
 * @author santiagomr
 *
 */
@SpringBootApplication()
public class NTTDataMainSpringT5 implements CommandLineRunner {

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

		// Creación de clientes

		customerService.generateCustomers("Alba", "Salcedo", "Delgado", "30/12/2000", "44532432C");
		customerService.generateCustomers("Juan", "Coronado", "Luque", "15/02/1995", "15563412Z");
		customerService.generateCustomers("Claudia", "Oliva", "Nuñez", "11/08/2001", "33521456F");
		customerService.generateCustomers("Julia", "Montaño", "Serrano", "06/03/1997", "88512332K");
		customerService.generateCustomers("Arancha", "Ruíz", "Moreno", "13/03/1992", "63532552L");
		customerService.generateCustomers("José", "Sánchez", "Pérez", "09/09/2004", "32532546R");

	}

}
