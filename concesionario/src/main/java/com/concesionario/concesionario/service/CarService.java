package com.concesionario.concesionario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.concesionario.concesionario.entity.CarEntity;
import com.concesionario.concesionario.entity.RentEntity;

public interface CarService {
	
	public void save(CarEntity car);
	public Optional<CarEntity> getById(Integer id);
	public Page<CarEntity> getAll(Pageable page);
	public void update(CarEntity car);
	public void deleteById(Integer id);
	public double getallbenefits(Integer id);
	public RentEntity getonerent(Integer idrent, Integer id);
	

}
