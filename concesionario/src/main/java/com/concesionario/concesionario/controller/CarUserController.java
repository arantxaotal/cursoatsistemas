package com.concesionario.concesionario.controller;

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

import com.concesionario.concesionario.dto.CarDto;
import com.concesionario.concesionario.dto.UserDto;
import com.concesionario.concesionario.entity.CarEntity;
import com.concesionario.concesionario.entity.UserEntity;
import com.concesionario.concesionario.service.CarService;
import com.concesionario.concesionario.service.UserService;
import com.concesionario.concesionario.service.mapper.CarttoDto;
import com.concesionario.concesionario.service.mapper.DtotoCar;
import com.concesionario.concesionario.service.mapper.DtotoUser;
import com.concesionario.concesionario.service.mapper.MapperService;
import com.concesionario.concesionario.service.mapper.UsertoDto;

@RestController
@RequestMapping("/car/{id}/user")
public class CarUserController {
	@Autowired private CarService carService;
	@Autowired private MapperService<UserEntity, UserDto> usertodtoService;
	@Autowired private MapperService<UserDto, UserEntity> dtotouserService;
	@PostMapping
	public void save(@PathVariable("id") Integer id,@RequestBody @Valid UserDto userdto)
	{
		carService.getById(id).get().setUser(dtotouserService.map(userdto));
	}
	@GetMapping
	public UserDto getAll(@PathVariable("id") Integer id,@RequestParam(name="page",required=false,defaultValue="0")Pageable page,
			@RequestParam(name="size",required=false,defaultValue="15")Integer size)
	{	
		return usertodtoService.map(carService.getById(id).get().getUser());
	}
	@PutMapping
	public void update(@PathVariable("id") Integer id,@RequestBody UserDto userdto)
	{
		carService.getById(id).get().setUser(dtotouserService.map(userdto));
		
	}
	@DeleteMapping
	public void deleteById(@PathVariable("id")Integer id)
	{
		carService.getById(id).get().setUser(new UserEntity());
	}
}
