package com.concesionario.concesionario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.concesionario.concesionario.dto.UserDto;
import com.concesionario.concesionario.entity.UserEntity;
import com.concesionario.concesionario.service.CarService;
import com.concesionario.concesionario.service.RentService;
import com.concesionario.concesionario.service.UserService;
import com.concesionario.concesionario.service.mapper.DtotoUser;
import com.concesionario.concesionario.service.mapper.UsertoDto;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired private UserService userService;
	@Autowired private CarService carService;
	@Autowired private RentService rentService;
	@Autowired private UsertoDto usertodtoService;
	@Autowired private DtotoUser dtotouserService;
	@GetMapping
	public void save(UserEntity user)
	{
		
	}
	public UserEntity getById(Integer id)
	{
		
	}
	public Page<UserDto> getAll(@RequestParam(name="page",required=false,defaultValue="0")Integer page,
			@RequestParam(name="size",required=false,defaultValue="15")Integer size,
			@RequestParam(name="name",required=false) String name)
	{
	    Pageable pageable= PageRequest.of(page,size);
		Page<UserDto> result=userService.getAll(pageable).map(x-> usertodtoService.map(x));
		return result;
	}
	public void update(UserEntity car)
	{
		
	}
	public void deleteById(Integer id)
	{
		
	}
	
	
}
