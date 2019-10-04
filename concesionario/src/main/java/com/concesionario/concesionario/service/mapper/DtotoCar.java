package com.concesionario.concesionario.service.mapper;

import org.springframework.stereotype.Service;

import com.concesionario.concesionario.dto.CarDto;
import com.concesionario.concesionario.entity.CarEntity;

@Service
public class DtotoCar implements MapperService<CarDto, CarEntity>{

	@Override
	public CarEntity map(CarDto tipo) {
		CarEntity carEntity = new CarEntity();
		carEntity.setId(tipo.getId());
		carEntity.setModel(tipo.getModel());
		carEntity.setBrand(tipo.getBrand());
		carEntity.setRent(tipo.getRent());
		carEntity.setUser(tipo.getUser());
		return carEntity;
	}

}
