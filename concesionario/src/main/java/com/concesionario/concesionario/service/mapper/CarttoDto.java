package com.concesionario.concesionario.service.mapper;

import org.springframework.stereotype.Service;

import com.concesionario.concesionario.dto.CarDto;
import com.concesionario.concesionario.entity.CarEntity;

@Service
public class CarttoDto implements MapperService<CarEntity, CarDto>{

	@Override
	public CarDto map(CarEntity tipo) {
		return new CarDto(tipo.getId(), tipo.getModel(), tipo.getBrand(), tipo.getUser(), tipo.getRent());
	}

}
