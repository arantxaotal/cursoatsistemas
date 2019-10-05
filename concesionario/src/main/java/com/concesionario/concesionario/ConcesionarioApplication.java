package com.concesionario.concesionario;


import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.concesionario.concesionario.entity.CarEntity;
import com.concesionario.concesionario.entity.RentEntity;
import com.concesionario.concesionario.entity.UserEntity;
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
		CarEntity carEntity=new CarEntity();
		UserEntity user=new UserEntity();
		user.setName("Paco");
		RentEntity rentEntity1=new RentEntity();
		UserEntity user2=new UserEntity();
		user2.setName("Pepe");	
		rentEntity1.setInitdate(LocalTime.of(9, 15));
		rentEntity1.setEnddate(LocalTime.of(18, 30));
		rentEntity1.setPrice(10);
		rentEntity1.setCar(carEntity);
		RentEntity rentEntity2=new RentEntity();	
		rentEntity1.setInitdate(LocalTime.of(14, 16));
		rentEntity1.setEnddate(LocalTime.of(20, 30));
		rentEntity1.setPrice(10);
		rentEntity1.setCar(carEntity);
		rentEntity1.setUser(user2);
		carEntity.setBrand("Opel");
		carEntity.setModel("Astra");
		List<RentEntity>rents = null;
		rents.add(rentEntity1);
		rents.add(rentEntity2);
		carEntity.setRent(rents);
		userservice.save(user);
		userservice.save(user2);
		carService.save(carEntity);
		rentservice.save(rentEntity1);
		rentservice.save(rentEntity2);
		
	}

}
