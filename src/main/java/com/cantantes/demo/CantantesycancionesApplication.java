package com.cantantes.demo;

import com.cantantes.demo.principal.Principal;
import com.cantantes.demo.repository.CantanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CantantesycancionesApplication implements CommandLineRunner {

	@Autowired
	private CantanteRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(CantantesycancionesApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repository);
		principal.mostrarMenu();




	}

}
