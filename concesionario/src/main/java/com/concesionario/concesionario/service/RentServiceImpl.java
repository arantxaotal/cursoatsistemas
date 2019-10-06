package com.concesionario.concesionario.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.concesionario.concesionario.entity.CarEntity;
import com.concesionario.concesionario.entity.RentEntity;
import com.concesionario.concesionario.exception.NotFoundException;
import com.concesionario.concesionario.repository.CarRepository;
import com.concesionario.concesionario.repository.RentRepository;

@Service
public class RentServiceImpl implements RentService {
	@Autowired RentRepository rentrepository;
	@Autowired CarRepository carRepository;
	@Override
	public void save(RentEntity rent) {
		rentrepository.save(rent);
		
	}

	@Override
	public Optional<RentEntity> getById(Integer id) {
		return rentrepository.findById(id);
	}

	@Override
	public Page<RentEntity> getAll(Pageable page) {
		return rentrepository.findAll(page);
	}

	@Override
	public void update(RentEntity rent) {
		rentrepository.saveAndFlush(rent);
	}

	@Override
	public void deleteById(Integer id) {
		rentrepository.deleteById(id);
		
	}

	@Override
	public RentEntity saverentcar(RentEntity rent, Integer idcar) {
		CarEntity carEntity= carRepository.findById(idcar).get();
		rent.setCar(carEntity);
		carEntity.getRent().add(rent);
		carRepository.save(carEntity);
		return rentrepository.save(rent);
	}

	@Override
	public RentEntity saverentuser(RentEntity rent, Integer iduser) {
		// TODO Auto-generated method stub
		return null;
	}

}
