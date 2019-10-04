package com.concesionario.concesionario.service.mapper;

import org.springframework.stereotype.Service;

import com.concesionario.concesionario.dto.UserDto;
import com.concesionario.concesionario.entity.UserEntity;

@Service
public class DtotoUser implements MapperService<UserDto, UserEntity> {

	@Override
	public UserEntity map(UserDto tipo) {
		UserEntity userEntity= new UserEntity();
		userEntity.setId(tipo.getId());
		userEntity.setCar(tipo.getCar());
		userEntity.setName(tipo.getName());
		userEntity.setRent(tipo.getRent());
		return userEntity;
	}

}
