package com.concesionario.concesionario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.concesionario.concesionario.entity.RentEntity;
import com.concesionario.concesionario.repository.RentRepository;

@Service
public class RentServiceImpl implements RentService {
	@Autowired RentRepository rentrepository;
	@Override
	public void save(RentEntity rent) {
		rentrepository.save(rent);
		
	}

	@Override
	public RentEntity getById(Integer id) {
		return rentrepository.getOne(id);
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

}
