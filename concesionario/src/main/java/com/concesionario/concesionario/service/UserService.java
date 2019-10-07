package com.concesionario.concesionario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.concesionario.concesionario.entity.RentEntity;
import com.concesionario.concesionario.entity.UserEntity;

public interface UserService {
	//USER-CONTROLLER
	public void save(UserEntity user);
	public Optional<UserEntity> getById(Integer id);
	public Page<UserEntity> getAll(Pageable page);
	public void update(UserEntity car);
	public void deleteById(Integer id);
	//CAR-USER CONTROLLER
	UserEntity saveusercar(UserEntity user, Integer idcar);
	UserEntity updateusercar(UserEntity user, Integer idcar, Integer iduser);
	public void deleteusercar(Integer idcar,Integer iduser);
	UserEntity getusercar(Integer idcar);
	//RENT-USER CONTROLLER
	UserEntity saveuserrent(UserEntity user, Integer idrent);
	UserEntity updateuserrent(UserEntity user, Integer iduser, Integer idrent);
	public void deleteuserrent(Integer idrent,Integer iduser);
	UserEntity getuserrent(Integer idcar);
}
