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

import com.concesionario.concesionario.dto.UserDto;
import com.concesionario.concesionario.entity.CarEntity;
import com.concesionario.concesionario.entity.RentEntity;
import com.concesionario.concesionario.entity.UserEntity;
import com.concesionario.concesionario.service.CarService;
import com.concesionario.concesionario.service.mapper.DtotoUser;
import com.concesionario.concesionario.service.mapper.MapperService;
import com.concesionario.concesionario.service.mapper.UsertoDto;

@RestController
@RequestMapping("/car/{id}/rent/{idrent}/user")
public class CarRentUserController {
	@Autowired private CarService carService;
	@Autowired private MapperService<UserEntity, UserDto> usertodtoService;
	@Autowired private MapperService<UserDto, UserEntity> dtotouserService;
	@PostMapping
	public void save(@PathVariable("id") Integer id,@PathVariable("idrent") Integer idrent,@RequestBody @Valid UserDto userdto)
	{
		carService.getById(id).get().getRent().get(idrent).setUser(dtotouserService.map(userdto));
	}
	@GetMapping
	public UserDto getAll(@PathVariable("id") Integer id,@PathVariable("idrent") Integer idrent)
	{	
		
		return usertodtoService.map(carService.getById(id).get().getRent().get(idrent).getUser());
	}
	@PutMapping("/{iduser}")
	public void update(@PathVariable("id")Integer id,
   @PathVariable("idrent") Integer idrent,@PathVariable("iduser")Integer iduser,@RequestBody UserDto userdto)
	{
		UserEntity userEntity = new UserEntity();
		userEntity=dtotouserService.map(userdto);
		carService.getById(id).get().getRent().get(idrent).setUser(userEntity);
		
	}
	@DeleteMapping("/{iduser}")
	public void deleteById(@PathVariable("id")
	Integer id,@PathVariable("idrent")Integer idrent,@PathVariable("iduser")Integer iduser)
	{
		carService.getById(id).get().getRent().get(idrent).setUser(new UserEntity());
	}
}
