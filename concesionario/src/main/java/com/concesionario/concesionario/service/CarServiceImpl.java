package com.concesionario.concesionario.service;

import java.util.List;
import java.util.Optional;

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
	public Optional<CarEntity> getById(Integer id) {
		return carrepository.findById(id);
	}

	@Override
	public List<CarEntity> getAll() {
		return carrepository.findAll();
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

}
