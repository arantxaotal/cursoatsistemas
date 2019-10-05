package com.concesionario.concesionario.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.concesionario.concesionario.entity.UserEntity;
import com.concesionario.concesionario.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired UserRepository userrepository;

	@Override
	public void save(UserEntity user) {
		userrepository.save(user);
		
	}

	@Override
	public Optional<UserEntity> getById(Integer id) {
		return userrepository.findById(id);
	}

	@Override
	public Page<UserEntity> getAll( Pageable page) {
		return userrepository.findAll(page);
	}

	@Override
	public void update(UserEntity car) {
		userrepository.saveAndFlush(car);
		
	}

	@Override
	public void deleteById(Integer id) {
		userrepository.deleteById(id);
		
	}
	
	

}
