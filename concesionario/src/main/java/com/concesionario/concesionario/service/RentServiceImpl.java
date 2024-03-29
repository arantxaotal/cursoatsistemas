package com.concesionario.concesionario.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.concesionario.concesionario.entity.CarEntity;
import com.concesionario.concesionario.entity.RentEntity;
import com.concesionario.concesionario.entity.UserEntity;
import com.concesionario.concesionario.exception.NotFoundException;
import com.concesionario.concesionario.repository.CarRepository;
import com.concesionario.concesionario.repository.RentRepository;
import com.concesionario.concesionario.repository.UserRepository;

@Service
public class RentServiceImpl implements RentService {
	@Autowired RentRepository rentrepository;
	@Autowired CarRepository carRepository;
	@Autowired UserRepository userRepository;
//CAR CONTROLLER
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
//CAR-RENT CONTROLLER
	@Override
	public RentEntity saverentcar(RentEntity rent, Integer idcar) {
		CarEntity carEntity= carRepository.findById(idcar).get();
		rent.setCar(carEntity);
		carEntity.getRent().add(rent);
		carRepository.saveAndFlush(carEntity);
		return rentrepository.save(rent);
	}

	@Override
	public RentEntity updaterentcar(RentEntity rent, Integer idcar, Integer idrent) {
		CarEntity carEntity=carRepository.findById(idcar).get();
		carEntity.getRent().remove(idrent);
		carEntity.getRent().add(rent);
		carRepository.saveAndFlush(carEntity);
		return rentrepository.saveAndFlush(rent);
		
	}

	@Override
	public void deleterentcar(Integer idcar, Integer idrent) {
		CarEntity carEntity=carRepository.findById(idcar).get();
		carEntity.getRent().remove(idrent);
		carRepository.saveAndFlush(carEntity);
		rentrepository.deleteById(idrent);
		
	}
	@Override
	public RentEntity getrentcar(Integer idcar, Integer idrent) {
		CarEntity carEntity=carRepository.findById(idcar).get();
		return carEntity.getRent().get(idrent);
	}
	@Override
	public Page<RentEntity> getallrentcar(Pageable page, Integer idcar) {
		CarEntity carEntity=carRepository.findById(idcar).get();
		return rentrepository.findByCar(page,carEntity);
	}
	@Override
	public Optional<Double> benefits(Integer idcar, LocalDate initDate, LocalDate endDate){
		CarEntity car = carRepository.findById(idcar).get();
		List<RentEntity> rentEntities = car.getRent();
		Double benefits=0.0;
		for(RentEntity entity : rentEntities) 
			if(entity.getInitdate().isAfter(initDate) && entity.getEnddate().isBefore(endDate))
				benefits += entity.getPrice();			
		return Optional.of(benefits);
	}
		
//USER-RENT CONTROLLER
	@Override
	public RentEntity saverentuser(RentEntity rent, Integer iduser) {
		UserEntity userEntity= userRepository.findById(iduser).get();
		rent.setUser(userEntity);
		userEntity.getRent().add(rent);
		userRepository.saveAndFlush(userEntity);
		return rentrepository.save(rent);
	}
	@Override
	public RentEntity updaterentuser(RentEntity rent, Integer iduser, Integer idrent) {
		UserEntity userEntity=userRepository.findById(iduser).get();
		userEntity.getRent().remove(idrent);
		userEntity.getRent().add(rent);
		userRepository.saveAndFlush(userEntity);
		return rentrepository.saveAndFlush(rent);
	}
	@Override
	public void deleterentuser(Integer iduser, Integer idrent) {
		UserEntity userEntity=userRepository.findById(iduser).get();
		userEntity.getRent().remove(idrent);
		userRepository.saveAndFlush(userEntity);
		rentrepository.deleteById(idrent);
		
	}
	@Override
	public RentEntity getrentuser(Integer iduser, Integer idrent) {
		UserEntity userEntity=userRepository.findById(iduser).get();
		return userEntity.getRent().get(idrent);
	}
	@Override
	public Page<RentEntity> getallrentuser(Pageable page,Integer iduser) {
		UserEntity userEntity = userRepository.findById(iduser).get();
		return rentrepository.findByUser(page, userEntity);
	}
	@Override
	public Page<RentEntity> getrentsuserdate(Integer iduser, LocalDate init, LocalDate end){
		UserEntity user = userRepository.findById(iduser).get();
		List<RentEntity> entities = user.getRent();
		List<RentEntity> result= new ArrayList<RentEntity>();
		for (int i = 0; i < entities.size(); i++) {
			if(entities.get(i).getInitdate().isAfter(init) && entities.get(i).getEnddate().isBefore(end))
			{
				result.add(entities.get(i));
			}
		}
		return new PageImpl<>(result);
	}

	

}
