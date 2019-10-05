package com.concesionario.concesionario.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.concesionario.concesionario.dto.UserDto;
import com.concesionario.concesionario.entity.RentEntity;
import com.concesionario.concesionario.entity.UserEntity;
import com.concesionario.concesionario.service.RentService;
import com.concesionario.concesionario.service.UserService;
import com.concesionario.concesionario.service.mapper.DtotoUser;
import com.concesionario.concesionario.service.mapper.UsertoDto;



@RestController
@RequestMapping("car/{id}/rent/{idrent}/user")
public class UserController {
	@Autowired private UserService userService;
	@Autowired private UsertoDto usertodtoService;
	@Autowired private DtotoUser dtotouserService;
	@Autowired private RentService rentservice;
	@PostMapping
	
	public void save(@RequestBody @Valid UserDto userdto)
	{
		UserEntity user= new UserEntity();
		user= dtotouserService.map(userdto);
		userService.save(user);
	}
	@GetMapping
	public UserDto getUser(@PathVariable("idrent")Integer id)
	{
		Optional<RentEntity> rentEntity=rentservice.getById(id);
		RentEntity rentEntity2 = rentEntity.get();
		return usertodtoService.map(rentEntity2.getUser());
	}
	@PutMapping
	public void update(@PathVariable("idrent")Integer id,@RequestBody UserDto userdto)
	{
		RentEntity rentEntity = new RentEntity();
		rentEntity.setId(id);
		UserEntity user= dtotouserService.map(userdto);
		rentEntity.setUser(user);
		rentservice.update(rentEntity);
	}
	@DeleteMapping
	public void deleteById(@PathVariable("idrent")Integer id)
	{
		UserEntity userEntity=rentservice.getById(id).get().getUser();
		userService.deleteById(userEntity.getId());
	}
	
}
