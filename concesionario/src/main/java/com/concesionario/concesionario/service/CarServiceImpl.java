package com.concesionario.concesionario.service;

import java.util.List;
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
public class CarServiceImpl implements CarService{
	@Autowired RentRepository rentrepository;
	@Autowired CarRepository carrepository;
	@Autowired UserRepository userRepository;
//CAR CONTROLLER
	@Override
	public void save(CarEntity car) {
		carrepository.save(car);
		
	}

	@Override
	public Optional<CarEntity> getById(Integer id) {
		return carrepository.findById(id);
	}

	@Override
	public Page<CarEntity> getAll(Pageable page) {
		return carrepository.findAll(page);
	}

	@Override
	public void update(CarEntity car) {
		carrepository.saveAndFlush(car);
		
	}

	@Override
	public void deleteById(Integer id) {
		carrepository.deleteById(id);
	}

	@Override
	public double getallbenefits(Integer id) {
		Optional<CarEntity>carEntity=carrepository.findById(id);
		double benefit=0;
		int n= carEntity.get().getRent().size();
		for (int i = 0; i <n ; i++) {
			benefit+=carEntity.get().getRent().get(i).getPrice();
		}
		return benefit;
	}
//RENT-CAR CONTROLLER

	@Override
	public CarEntity savecarrent(CarEntity car, Integer idrent) {
		RentEntity rentEntity=rentrepository.findById(idrent).get();
		rentEntity.setCar(car);
		rentrepository.saveAndFlush(rentEntity);
		return carrepository.saveAndFlush(car);
	}

	@Override
	public CarEntity updatecarrent(CarEntity car, Integer idcar, Integer idrent) {
		RentEntity rentEntity=rentrepository.findById(idrent).get();
		rentEntity.setCar(car);
		rentrepository.saveAndFlush(rentEntity);
		return carrepository.saveAndFlush(car);
	}

	@Override
	public void deletecarrent(Integer idrent, Integer idcar) {
		RentEntity rentEntity = rentrepository.findById(idrent).get();
		rentEntity.setCar(null);
		rentrepository.saveAndFlush(rentEntity);
		carrepository.deleteById(idcar);
		
	}

	@Override
	public CarEntity getcarrent(Integer idrent) {
		RentEntity rentEntity = rentrepository.findById(idrent).get();
		return rentEntity.getCar();
	}
//USER-CAR CONTROLLER
	@Override
	public CarEntity savecaruser(CarEntity car, Integer iduser) {
		UserEntity userEntity = userRepository.findById(iduser).get();
		userEntity.getCar().add(car);
		userRepository.saveAndFlush(userEntity);
		return carrepository.save(car);
	}

	@Override
	public CarEntity updatecaruser(CarEntity car, Integer idcar, Integer iduser) {
		UserEntity userEntity = userRepository.findById(iduser).get();
		userEntity.getCar().add(car);
		userRepository.saveAndFlush(userEntity);
		return carrepository.saveAndFlush(car);
	}

	@Override
	public void deletecaruser(Integer iduser, Integer idcar) {
		UserEntity userEntity = userRepository.findById(iduser).get();
		userEntity.setCar(null);
		userRepository.saveAndFlush(userEntity);
		carrepository.deleteById(idcar);
	}

	@Override
	public CarEntity getcaruser(Integer iduser, Integer idcar) {
		UserEntity userEntity=userRepository.findById(iduser).get();
		return userEntity.getCar().get(idcar);
	}

	@Override
	public Page<CarEntity> getallcaruser(Pageable pageable,Integer iduser) {
		UserEntity userEntity = userRepository.findById(iduser).get();
		return carrepository.findByUser(pageable, userEntity);
	}

}
