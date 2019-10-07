package com.concesionario.concesionario.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.concesionario.concesionario.entity.CarEntity;
import com.concesionario.concesionario.entity.RentEntity;
import com.concesionario.concesionario.entity.UserEntity;
import com.concesionario.concesionario.repository.CarRepository;
import com.concesionario.concesionario.repository.RentRepository;
import com.concesionario.concesionario.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired RentRepository rentrepository;
	@Autowired CarRepository carRepository;
	@Autowired UserRepository userrepository;
//USER CONTROLLER
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
	//CAR-USER CONTROLLER

	@Override
	public UserEntity saveusercar(UserEntity user, Integer idcar) {
		CarEntity carEntity= carRepository.findById(idcar).get();
		user.getCar().add(carEntity);
		carEntity.setUser(user);
		carRepository.saveAndFlush(carEntity);
		return userrepository.save(user);
	}

	@Override
	public UserEntity updateusercar(UserEntity user, Integer idcar, Integer iduser) {
		CarEntity carEntity=carRepository.findById(idcar).get();
		carEntity.setUser(user);
		carRepository.saveAndFlush(carEntity);
		return userrepository.saveAndFlush(user);
	}

	@Override
	public void deleteusercar(Integer idcar, Integer iduser) {
		CarEntity carEntity = carRepository.findById(idcar).get();
		carEntity.setUser(null);
		userrepository.deleteById(iduser);
		
	}

	@Override
	public UserEntity getusercar(Integer idcar) {
		CarEntity carEntity = carRepository.findById(idcar).get();
		return carEntity.getUser();
	}
//RENT-USER CONTROLLER
	@Override
	public UserEntity saveuserrent(UserEntity user, Integer idrent) {
		RentEntity rentEntity = rentrepository.findById(idrent).get();
		rentEntity.setUser(user);
		rentrepository.saveAndFlush(rentEntity);
		return userrepository.save(user);
		
	}

	@Override
	public UserEntity updateuserrent(UserEntity user, Integer iduser, Integer idrent) {
		RentEntity rentEntity = rentrepository.findById(idrent).get();
		rentEntity.setUser(user);
		rentrepository.saveAndFlush(rentEntity);
		return userrepository.saveAndFlush(user);
		
	}

	@Override
	public void deleteuserrent(Integer idcar, Integer iduser) {
		CarEntity carEntity=carRepository.findById(idcar).get();
		carEntity.setUser(null);
		userrepository.deleteById(iduser);
	}

	@Override
	public UserEntity getuserrent(Integer idcar) {
		CarEntity carEntity=carRepository.findById(idcar).get();
		return carEntity.getUser();
	}
		

	

}
