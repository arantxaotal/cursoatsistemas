package com.concesionario.concesionario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.concesionario.concesionario.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {

}
