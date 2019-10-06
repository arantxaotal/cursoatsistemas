package com.concesionario.concesionario.controller;

import java.security.PublicKey;
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
import com.concesionario.concesionario.service.CarService;
import com.concesionario.concesionario.service.RentService;
import com.concesionario.concesionario.service.mapper.CarttoDto;
import com.concesionario.concesionario.service.mapper.DtotoCar;
import com.concesionario.concesionario.service.mapper.DtotoRent;
import com.concesionario.concesionario.service.mapper.MapperService;
import com.concesionario.concesionario.service.mapper.RenttoDto;

import javassist.NotFoundException;

@RestController
@RequestMapping("/car/{id}/rent")
public class CarRentController {
	@Autowired private CarService carService;
	@Autowired private RentService rentService;
	@Autowired private MapperService<RentEntity, RentDto>renttodtoService;
	@Autowired private MapperService<RentDto, RentEntity> dtotorentService;
	@Autowired private MapperService<CarEntity,CarDto> carttodtoService;
	@Autowired private MapperService<CarDto,CarEntity> dtotocarService;
	@PostMapping
	public RentDto save(@PathVariable("id") Integer id,@RequestBody @Valid RentDto rentdto)  {
		return renttodtoService.map(rentService.saverentcar(dtotorentService.map(rentdto),id));
	}
	@GetMapping
	public List<RentDto> getAll(@PathVariable("id") Integer id)
	{	
		List<RentDto> rentlistDtos = new ArrayList<RentDto>();
		int n =carService.getById(id).get().getRent().size();
		for (int i = 0; i < n; i++) {
			rentlistDtos.add(renttodtoService.map(carService.getById(id).get().getRent().get(i)));
		}
		return rentlistDtos;
		
	}
	@GetMapping("/{idrent}")
	public RentDto getOne(@PathVariable("idrent") Integer idrent,@PathVariable("id")Integer id) 
	{
		return renttodtoService.map(carService.getonerent(idrent,id));

	}
	@PutMapping("/{idrent}")
	public void update(@PathVariable("id") Integer id,@PathVariable("idrent")Integer idrent,@RequestBody RentDto rentdto)
	{
		RentEntity rentEntity= dtotorentService.map(rentdto);
		carService.getById(id).get().getRent().remove(idrent);
		carService.getById(id).get().getRent().add(rentEntity);
		
	}
	@DeleteMapping("/{idrent}")
	public void deleteById(@PathVariable("id") Integer id,@PathVariable("idrent")Integer idrent)
	{
		carService.getById(id).get().getRent().remove(idrent);
	}
}
