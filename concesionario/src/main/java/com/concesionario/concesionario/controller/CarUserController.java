package com.concesionario.concesionario.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
import com.concesionario.concesionario.exception.NotFoundException;
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
	@Autowired private UserService userService;
	@Autowired private MapperService<UserEntity, UserDto> usertodtoService;
	@Autowired private MapperService<UserDto, UserEntity> dtotouserService;
	@PostMapping
	public UserDto save(@PathVariable("id") Integer id,@RequestBody @Valid UserDto userdto) throws IllegalArgumentException
	{
		return usertodtoService.map(userService.saveusercar(dtotouserService.map(userdto), id)); 
	}
	@GetMapping
	public UserDto getAll(@PathVariable("id") Integer id) throws NotFoundException
	{	
		return usertodtoService.map(userService.getusercar(id));
	}	
	@PutMapping("/{iduser}")
	public void update(@PathVariable("id") Integer id,@PathVariable("iduser") Integer iduser,@RequestBody UserDto userdto) throws NotFoundException
	{
		userService.updateusercar(dtotouserService.map(userdto), id, iduser);
	}
	@DeleteMapping("/{iduser}")
	public void deleteById(@PathVariable("id")Integer id,@PathVariable("iduser")Integer iduser) throws NotFoundException
	{
		userService.deleteusercar(id, iduser);
	}
}
