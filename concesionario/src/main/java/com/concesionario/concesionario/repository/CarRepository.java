package com.concesionario.concesionario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.concesionario.concesionario.entity.CarEntity;

public interface CarRepository extends JpaRepository<CarEntity, Integer>{

}
