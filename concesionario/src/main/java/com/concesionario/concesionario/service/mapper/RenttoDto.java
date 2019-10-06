package com.concesionario.concesionario.service.mapper;

import org.springframework.stereotype.Service;

import com.concesionario.concesionario.dto.RentDto;
import com.concesionario.concesionario.entity.RentEntity;

@Service
public class RenttoDto implements MapperService<RentEntity, RentDto>{

	@Override
	public RentDto map(RentEntity tipo) {
		return new RentDto(tipo.getId(),tipo.getUser(), tipo.getCar(), tipo.getInitdate(), tipo.getEnddate(), tipo.getPrice());
	}

}
