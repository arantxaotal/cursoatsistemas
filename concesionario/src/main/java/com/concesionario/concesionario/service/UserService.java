package com.concesionario.concesionario.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.concesionario.concesionario.entity.UserEntity;

public interface UserService {
	
	public void save(UserEntity user);
	public Optional<UserEntity> getById(Integer id);
	public Page<UserEntity> getAll(Pageable page);
	public void update(UserEntity car);
	public void deleteById(Integer id);

}
