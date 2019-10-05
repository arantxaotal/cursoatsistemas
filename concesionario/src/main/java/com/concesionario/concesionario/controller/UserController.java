package com.concesionario.concesionario.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.concesionario.concesionario.dto.RentDto;
import com.concesionario.concesionario.dto.UserDto;
import com.concesionario.concesionario.entity.RentEntity;
import com.concesionario.concesionario.entity.UserEntity;
import com.concesionario.concesionario.service.RentService;
import com.concesionario.concesionario.service.UserService;
import com.concesionario.concesionario.service.mapper.DtotoUser;
import com.concesionario.concesionario.service.mapper.UsertoDto;



@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired private UserService userService;
	@Autowired private UsertoDto usertodtoService;
	@Autowired private DtotoUser dtotouserService;
	@PostMapping
	
	public void save(@RequestBody @Valid UserDto userdto)
	{
		UserEntity user= new UserEntity();
		user= dtotouserService.map(userdto);
		userService.save(user);
	}
	@GetMapping
	public Page<UserDto> getAll(@RequestParam(name="page",required=false,defaultValue="0")Pageable page,
			@RequestParam(name="size",required=false,defaultValue="15")Integer size)
	{	
		return userService.getAll(page).map(x-> usertodtoService.map(x));
	}
	@GetMapping("/{id}")
	public UserDto getUser(@PathVariable("id")Integer id)
	{
		return usertodtoService.map(userService.getById(id).get());
	}
	@PutMapping
	public void update(@PathVariable("id")Integer id,@RequestBody UserDto userdto)
	{
		UserEntity userEntity=new UserEntity();
		userEntity.setId(id);
		userEntity= dtotouserService.map(userdto);
		userService.update(userEntity);
	}
	@DeleteMapping
	public void deleteById(@PathVariable("id")Integer id)
	{
		userService.deleteById(id);
	}
	
}
