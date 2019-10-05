package com.concesionario.concesionario;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.concesionario.concesionario.service.CarService;
import com.concesionario.concesionario.service.RentService;
import com.concesionario.concesionario.service.UserService;

@SpringBootApplication
public class ConcesionarioApplication implements CommandLineRunner{
	
	 @Autowired UserService userservice;
	 @Autowired RentService  rentservice;
	 @Autowired CarService carService;
	public static void main(String[] args) {
		SpringApplication.run(ConcesionarioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
	}

}
