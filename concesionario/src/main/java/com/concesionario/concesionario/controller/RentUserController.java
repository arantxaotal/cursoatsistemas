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


import com.concesionario.concesionario.dto.RentDto;
import com.concesionario.concesionario.dto.UserDto;
import com.concesionario.concesionario.entity.RentEntity;
import com.concesionario.concesionario.entity.UserEntity;
import com.concesionario.concesionario.service.RentService;
import com.concesionario.concesionario.service.UserService;
import com.concesionario.concesionario.service.mapper.DtotoUser;
import com.concesionario.concesionario.service.mapper.MapperService;
import com.concesionario.concesionario.service.mapper.UsertoDto;

@RestController
@RequestMapping("/rent/{id}/user")
public class RentUserController {
	@Autowired private UserService userService;
	@Autowired private MapperService<UserEntity, UserDto> usertodtoService;
	@Autowired private MapperService<UserDto, UserEntity> dtotouserService;
	@Autowired private RentService rentService;
	@PostMapping
	public UserDto save(@PathVariable("id") Integer id,@RequestBody @Valid UserDto userdto)
	{
		return usertodtoService.map(userService.saveuserrent(dtotouserService.map(userdto), id));
	}
	@GetMapping
	public UserDto getAll(@PathVariable("id") Integer id)
	{	
		return usertodtoService.map(userService.getuserrent(id));
	}	
	@PutMapping("/{iduser}")
	public void update(@PathVariable("id") Integer id,@PathVariable("iduser")Integer iduser,@RequestBody UserDto userDto)
	{
		userService.updateuserrent(dtotouserService.map(userDto), id,iduser );
	}
	@DeleteMapping("/{iduser}")
	public void deleteById(@PathVariable("id")Integer id,@PathVariable("iduser")Integer iduser)
	{
		userService.deleteuserrent(id, iduser);
	}
}
