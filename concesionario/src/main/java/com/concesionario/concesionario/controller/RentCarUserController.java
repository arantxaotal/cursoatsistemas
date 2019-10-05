package com.concesionario.concesionario.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.concesionario.concesionario.dto.CarDto;
import com.concesionario.concesionario.dto.UserDto;
import com.concesionario.concesionario.entity.CarEntity;
import com.concesionario.concesionario.entity.UserEntity;
import com.concesionario.concesionario.service.RentService;
import com.concesionario.concesionario.service.mapper.CarttoDto;
import com.concesionario.concesionario.service.mapper.DtotoCar;
import com.concesionario.concesionario.service.mapper.DtotoUser;
import com.concesionario.concesionario.service.mapper.UsertoDto;

@RestController
@RequestMapping("/rent/{id}/car/{idcar}/user")
public class RentCarUserController {
	@Autowired private RentService rentService;
	@Autowired private UsertoDto usertodtoService;
	@Autowired private DtotoUser dtotouserService;
	@PostMapping
	public void save(@PathVariable("id") Integer id,@PathVariable("idcar") Integer idcar,@RequestBody @Valid UserDto userdto)
	{
		rentService.getById(id).get().getCar().setUser(dtotouserService.map(userdto));
	}
	@GetMapping
	public UserDto getAll(@PathVariable("id") Integer id,@PathVariable("idcar") Integer idcar)
	{	UserEntity userEntity= rentService.getById(id).get().getCar().getUser();
		return usertodtoService.map(userEntity);
	}
	@PutMapping("/{iduser}")
	public void update(@PathVariable("id")Integer id,
   @PathVariable("idcar1") Integer idcar1,@PathVariable("idcar")Integer idcar,@RequestBody UserDto userDto)
	{
		UserEntity userEntity = new UserEntity();
		userEntity=dtotouserService.map(userDto);
		rentService.getById(id).get().getCar().setUser(userEntity);
		
	}
	@DeleteMapping("/{iduser}")
	public void deleteById(@PathVariable("id")
	Integer id,@PathVariable("idcar1")Integer idcar1,@PathVariable("iduser")Integer iduser)
	{
		rentService.getById(id).get().getCar().setUser(new UserEntity());
	}
}
