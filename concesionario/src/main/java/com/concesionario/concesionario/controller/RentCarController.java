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
import com.concesionario.concesionario.entity.RentEntity;
import com.concesionario.concesionario.service.CarService;
import com.concesionario.concesionario.service.RentService;
import com.concesionario.concesionario.service.mapper.CarttoDto;
import com.concesionario.concesionario.service.mapper.DtotoCar;
import com.concesionario.concesionario.service.mapper.DtotoRent;
import com.concesionario.concesionario.service.mapper.RenttoDto;

@RestController
@RequestMapping("/rent/{id}/car")
public class RentCarController {
	@Autowired private CarttoDto cartodtoService;
	@Autowired private DtotoCar dtotocarService;
	@Autowired private RentService rentService;
	@PostMapping
	public void save(@PathVariable("id") Integer id,@RequestBody @Valid CarDto cardto)
	{
		rentService.getById(id).get().setCar(dtotocarService.map(cardto));
	}
	@GetMapping
	public CarDto getAll(@PathVariable("id")Integer id)
	{	
	
		return cartodtoService.map(rentService.getById(id).get().getCar());
	}	
	@PutMapping
	public void update(@PathVariable("id") Integer id,@RequestBody CarDto cardto)
	{
		rentService.getById(id).get().setCar(dtotocarService.map(cardto));
	}
	@DeleteMapping
	public void deleteById(@PathVariable("id")Integer id)
	{
		rentService.getById(id).get().setCar(new CarEntity());
	}
}
