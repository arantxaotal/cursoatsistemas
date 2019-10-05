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
import com.concesionario.concesionario.dto.RentDto;
import com.concesionario.concesionario.entity.CarEntity;
import com.concesionario.concesionario.entity.RentEntity;
import com.concesionario.concesionario.service.UserService;
import com.concesionario.concesionario.service.mapper.CarttoDto;
import com.concesionario.concesionario.service.mapper.DtotoCar;
import com.concesionario.concesionario.service.mapper.DtotoRent;
import com.concesionario.concesionario.service.mapper.RenttoDto;

@RestController
@RequestMapping("/user/{id}/rent/{idrent}/car")
public class UserRentCarController {
	@Autowired private UserService userService;
	@Autowired private CarttoDto cartodtoService;
	@Autowired private DtotoCar dtotocarService;
	@PostMapping
	public void save(@PathVariable("id") Integer id,@PathVariable("idrent") Integer idrent,@RequestBody @Valid CarDto cardto)
	{
		userService.getById(id).get().getRent().get(idrent).setCar(dtotocarService.map(cardto));
	}
	@GetMapping
	public CarDto getAll(@PathVariable("id") Integer id,@PathVariable("idrent") Integer idrent)
	{	
		return cartodtoService.map(userService.getById(id).get().getRent().get(idrent).getCar());

	}
	@PutMapping("/{idrent}")
	public void update(@PathVariable("id")Integer id,
   @PathVariable("idrent") Integer idrent,@PathVariable("idcar")Integer idcar,@RequestBody CarDto carDto)
	{
		userService.getById(id).get().getRent().get(idrent).setCar(dtotocarService.map(carDto));
	}
	@DeleteMapping("/{idrent}")
	public void deleteById(@PathVariable("id")
	Integer id,@PathVariable("idcar")Integer idcar,@PathVariable("idrent")Integer idrent)
	{
		userService.getById(id).get().getRent().get(idrent).setCar(new CarEntity());
	}
}
