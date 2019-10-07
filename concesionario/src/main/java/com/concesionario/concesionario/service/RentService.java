package com.concesionario.concesionario.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.concesionario.concesionario.entity.RentEntity;
import com.concesionario.concesionario.exception.NotFoundException;

public interface RentService {
	public void save(RentEntity rent);
	public Optional<RentEntity> getById(Integer id);
	public Page<RentEntity> getAll( Pageable page);
	public void update(RentEntity rent);
	public void deleteById(Integer id);
	//CAR-RENT CONTROLLER
	public RentEntity saverentcar(RentEntity rent,Integer idcar) ;
	public RentEntity updaterentcar(RentEntity rent, Integer idcar, Integer idrent);
	public void deleterentcar(Integer idcar, Integer idrent);
	public RentEntity getrentcar(Integer idcar,Integer idrent);
	public Page<RentEntity> getallrentcar(Pageable page,Integer idcar);
	//USER-RENT CONTROLLER
	public RentEntity saverentuser(RentEntity rent,Integer iduser) ;
	public RentEntity updaterentuser(RentEntity rent, Integer iduser, Integer idrent);
	public void deleterentuser(Integer iduser, Integer idrent);
	public RentEntity getrentuser(Integer iduser,Integer idrent);
	public Page<RentEntity> getallrentuser(Pageable page,Integer iduser);
	public Optional<Double> benefits(Integer idcar, LocalDate initDate, LocalDate endDate);
	Page<RentEntity> getrentsuserdate(Integer iduser, LocalDate init, LocalDate end);
}
