package com.concesionario.concesionario.service.mapper;

import org.springframework.stereotype.Service;

import com.concesionario.concesionario.dto.UserDto;
import com.concesionario.concesionario.entity.UserEntity;


@Service
public class UsertoDto implements MapperService<UserEntity, UserDto>{

	@Override
	public UserDto map(UserEntity tipo) {
		return new UserDto(tipo.getId(), tipo.getName(), tipo.getCar(), tipo.getRent());
	}


}
