package com.concesionario.concesionario.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.concesionario.concesionario.entity.RentEntity;

public interface RentService {
	public void save(RentEntity rent);
	public Optional<RentEntity> getById(Integer id);
	public Page<RentEntity> getAll( Pageable page);
	public void update(RentEntity rent);
	public void deleteById(Integer id);

}
