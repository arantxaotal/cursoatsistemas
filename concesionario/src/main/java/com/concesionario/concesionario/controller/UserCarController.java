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
import org.springframework.web.bind.annotation.RestController;

import com.concesionario.concesionario.dto.CarDto;
import com.concesionario.concesionario.entity.CarEntity;
import com.concesionario.concesionario.service.CarService;
import com.concesionario.concesionario.service.UserService;
import com.concesionario.concesionario.service.mapper.MapperService;

@RestController
@RequestMapping("/user/{id}/car")
public class UserCarController {
	@Autowired private CarService carService;
	@Autowired private MapperService<CarEntity, CarDto> cartodtoService;
	@Autowired private MapperService<CarDto, CarEntity> dtotocarService;
	@Autowired private UserService userService;
	@PostMapping
	public CarDto save(@PathVariable("id") Integer id,@RequestBody @Valid CarDto cardto)
	{
		return cartodtoService.map(carService.savecaruser(dtotocarService.map(cardto), id)); 
		
	}
	@GetMapping
	public Page<CarDto> getAll(@PathVariable("id") Integer id)
	{	
		Pageable carpage = PageRequest.of(0, 10, Sort.Direction.ASC, "brand");
		
		return carService.getallcaruser(carpage, id).map(cartodtoService::map);
	}	
	@GetMapping("/{idcar}")
	public CarDto getOne(@PathVariable("idcar") Integer idcar,@PathVariable("id")Integer id) 
	{
		return cartodtoService.map(carService.getcaruser(id, idcar));
		
	}
	@PutMapping("/{idcar}")
	public CarDto update(@PathVariable("id") Integer id,@PathVariable("idcar")Integer idcar,@RequestBody CarDto cardto)
	{
		return cartodtoService.map(carService.updatecaruser(dtotocarService.map(cardto),idcar, id));
	}
	@DeleteMapping("/{idcar}")
	public void deleteById(@PathVariable("id")Integer id,@PathVariable("idcar")Integer idcar)
	{
		carService.deletecaruser(id, idcar);
	}
}
