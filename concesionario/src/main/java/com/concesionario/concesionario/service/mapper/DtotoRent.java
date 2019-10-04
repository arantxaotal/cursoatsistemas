package com.concesionario.concesionario.service.mapper;

import org.springframework.stereotype.Service;

import com.concesionario.concesionario.dto.RentDto;
import com.concesionario.concesionario.entity.RentEntity;

@Service
public class DtotoRent implements MapperService<RentDto, RentEntity>{

	@Override
	public RentEntity map(RentDto tipo) {
		RentEntity rententity = new RentEntity();
		rententity.setCar(tipo.getCar());
		rententity.setInitdate(tipo.getInitdate());
		rententity.setEnddate(tipo.getEnddate());
		rententity.setPrice(tipo.getPrice());
		rententity.setUser(tipo.getUser());
		return rententity;
	}

}
