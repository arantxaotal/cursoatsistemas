package com.concesionario.concesionario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.concesionario.concesionario.entity.CarEntity;
import com.concesionario.concesionario.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService{
	@Autowired CarRepository carrepository;
	@Override
	public void save(CarEntity car) {
		carrepository.save(car);
		
	}

	@Override
	public CarEntity getById(Integer id) {
		return carrepository.getOne(id);
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

}
