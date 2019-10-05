package com.concesionario.concesionario.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
import com.concesionario.concesionario.entity.CarEntity;
import com.concesionario.concesionario.service.CarService;
import com.concesionario.concesionario.service.RentService;
import com.concesionario.concesionario.service.UserService;
import com.concesionario.concesionario.service.mapper.CarttoDto;
import com.concesionario.concesionario.service.mapper.DtotoCar;

import javassist.NotFoundException;

@RestController
@RequestMapping("/car")
public class CarController {
	@Autowired private RentService rentservice;
	@Autowired private CarService carService;
	@Autowired private CarttoDto cartodtoService;
	@Autowired private DtotoCar dtotocarService;
	@PostMapping
	public void save(@RequestBody @Valid CarDto cardto)
	{
		CarEntity car= new CarEntity();
		car= dtotocarService.map(cardto);
		carService.save(car);
	}
	@GetMapping
	public List<CarDto> getAll()
	{	List<CarEntity> carEntity=new ArrayList<CarEntity>();
		carEntity=carService.getAll();
		List<CarDto> dto = new ArrayList<CarDto>();
		for (int i = 0; i < carEntity.size(); i++) {

			dto.add( cartodtoService.map(carEntity.get(i)));
		}
		return dto;
	}	
	@GetMapping("/{id}")
	public CarDto getOne(@PathVariable("id") Integer id) throws NotFoundException
	{
		CarEntity carEntity=new CarEntity();
		carEntity=carService.getById(id).get();
		return cartodtoService.map(carEntity);
		
	}
	@PutMapping
	public void update(@PathVariable("id") Integer id,@RequestBody CarDto cardto)
	{
		CarEntity car= new CarEntity();
		car.setId(id);
		car= dtotocarService.map(cardto);
		carService.update(car);
	}
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id")Integer id)
	{
		carService.deleteById(id);
	}
	@GetMapping("/benefits")
	public double getallbenefits(@PathVariable("id")Integer id)
	{
		return carService.getallbenefits(id);
	}
}
