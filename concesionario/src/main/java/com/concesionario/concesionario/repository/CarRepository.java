package com.concesionario.concesionario.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.concesionario.concesionario.entity.CarEntity;
import com.concesionario.concesionario.entity.UserEntity;



public interface CarRepository extends JpaRepository<CarEntity, Integer>{
	
	Page<CarEntity> findByUser(Pageable pageable, UserEntity userEntity);

}
