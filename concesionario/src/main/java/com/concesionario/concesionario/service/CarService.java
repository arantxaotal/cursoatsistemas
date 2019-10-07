package com.concesionario.concesionario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.concesionario.concesionario.entity.CarEntity;
import com.concesionario.concesionario.entity.RentEntity;
import com.concesionario.concesionario.entity.UserEntity;

public interface CarService {
	
	public void save(CarEntity car);
	public Optional<CarEntity> getById(Integer id);
	public Page<CarEntity> getAll(Pageable page);
	public void update(CarEntity car);
	public void deleteById(Integer id);
	public double getallbenefits(Integer id);
	//RENT-CAR CONTROLLER
	CarEntity savecarrent(CarEntity car, Integer idrent);
	CarEntity updatecarrent(CarEntity car, Integer idcar, Integer idrent);
	public void deletecarrent(Integer idrent,Integer idcar);
	CarEntity getcarrent(Integer idrent);	
	//USER-CAR CONTROLLER
	CarEntity savecaruser(CarEntity car, Integer iduser);
	CarEntity updatecaruser(CarEntity car, Integer idcar, Integer iduser);
	public void deletecaruser(Integer iduser,Integer idcar);
	CarEntity getcaruser(Integer iduser,Integer idcar);	
	Page<CarEntity> getallcaruser(Pageable page,Integer iduser);

}
