package com.concesionario.concesionario.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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

import com.concesionario.concesionario.dto.CarDto;
import com.concesionario.concesionario.dto.RentDto;
import com.concesionario.concesionario.entity.CarEntity;
import com.concesionario.concesionario.entity.RentEntity;
import com.concesionario.concesionario.exception.NotFoundException;
import com.concesionario.concesionario.service.CarService;
import com.concesionario.concesionario.service.RentService;
import com.concesionario.concesionario.service.mapper.CarttoDto;
import com.concesionario.concesionario.service.mapper.DtotoCar;
import com.concesionario.concesionario.service.mapper.DtotoRent;
import com.concesionario.concesionario.service.mapper.MapperService;
import com.concesionario.concesionario.service.mapper.RenttoDto;

@RestController
@RequestMapping("/rent/{id}/car")
public class RentCarController {
	@Autowired private MapperService<CarEntity, CarDto> cartodtoService;
	@Autowired private MapperService<CarDto, CarEntity> dtotocarService;
	@Autowired private RentService rentService;
	@Autowired private CarService carservice;
	@PostMapping
	public CarDto save(@PathVariable("id") Integer id,@RequestBody @Valid CarDto cardto) throws IllegalArgumentException
	{
		return cartodtoService.map(carservice.savecarrent(dtotocarService.map(cardto), id));
	}
	@GetMapping
	public CarDto getAll(@PathVariable("id")Integer id) throws NotFoundException
	{	
	
		return cartodtoService.map(carservice.getcarrent(id));
	}	
	@PutMapping("/{idcar}")
	public void update(@PathVariable("id") Integer id,@PathVariable("id") Integer idcar,@RequestBody CarDto cardto) throws NotFoundException
	{
		carservice.updatecarrent(dtotocarService.map(cardto), idcar, id);
	}
	@DeleteMapping("/{idcar}")
	public void deleteById(@PathVariable("id")Integer id,@PathVariable("id")Integer idcar) throws NotFoundException
	{
		carservice.deletecarrent(id, idcar);
	}
	@GetMapping("/benefits/{idcar}")
	public Optional<Double> benefits (@PathVariable("idcar") Integer idcar, 
			@RequestParam(name="init",required=true) long init, 
			@RequestParam(name="end",required=true) long end) throws NotFoundException {
		
		LocalDate initDate = LocalDate.ofEpochDay(init);
		LocalDate endDate = LocalDate.ofEpochDay(end);	
		return rentService.benefits(idcar, initDate, endDate);
	}
}
