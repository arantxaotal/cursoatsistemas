package com.concesionario.concesionario.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.concesionario.concesionario.entity.CarEntity;
import com.concesionario.concesionario.entity.RentEntity;
import com.concesionario.concesionario.entity.UserEntity;

public interface RentRepository extends JpaRepository<RentEntity,Integer>{

	Page<RentEntity> findByCar(Pageable page, CarEntity carEntity);
	
	Page<RentEntity> findByUser(Pageable page, UserEntity userEntity);


}
