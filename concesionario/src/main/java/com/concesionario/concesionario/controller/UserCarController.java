package com.concesionario.concesionario.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.concesionario.concesionario.dto.RentDto;
import com.concesionario.concesionario.entity.CarEntity;
import com.concesionario.concesionario.entity.UserEntity;
import com.concesionario.concesionario.service.CarService;
import com.concesionario.concesionario.service.UserService;
import com.concesionario.concesionario.service.mapper.CarttoDto;
import com.concesionario.concesionario.service.mapper.DtotoCar;

@RestController
@RequestMapping("/user/{id}/car/")
public class UserCarController {
	@Autowired private CarService carService;
	@Autowired private CarttoDto cartodtoService;
	@Autowired private DtotoCar dtotocarService;
	@Autowired private UserService userService;
	@PostMapping
	public void save(@PathVariable("id") Integer id,@RequestBody @Valid CarDto cardto)
	{
		userService.getById(id).get().getCar().add(dtotocarService.map(cardto));
	}
	@GetMapping
	public List<CarDto> getAll(@PathVariable("id") Integer id)
	{	
		List<CarDto> carlistDtos = new ArrayList<CarDto>();
		int n =userService.getById(id).get().getCar().size();
		for (int i = 0; i < n; i++) {
			carlistDtos.add(cartodtoService.map(userService.getById(id).get().getCar().get(i)));
		}
		return carlistDtos;
	}	
	@GetMapping("/{idcar}")
	public CarDto getOne(@PathVariable("idcar") Integer idcar,@RequestParam(name = "id")Integer id) 
	{
		return cartodtoService.map(userService.getById(id).get().getCar().get(id));
		
	}
	@PutMapping("/{idcar}")
	public void update(@PathVariable("id") Integer id,@PathVariable("idcar")Integer idcar,@RequestBody CarDto cardto)
	{
		userService.getById(id).get().getCar().remove(idcar);
		userService.getById(id).get().getCar().add(dtotocarService.map(cardto));
	}
	@DeleteMapping("/{idcar}")
	public void deleteById(@PathVariable("id")Integer id,@PathVariable("idcar")Integer idcar)
	{
		userService.getById(id).get().getCar().remove(idcar);
	}
}
