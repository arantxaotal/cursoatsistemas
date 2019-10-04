package com.concesionario.concesionario.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.concesionario.concesionario.entity.CarEntity;

public interface CarService {
	
	public void save(CarEntity car);
	public CarEntity getById(Integer id);
	public Page<CarEntity> getAll(Pageable page);
	public void update(CarEntity car);
	public void deleteById(Integer id);
	

}
