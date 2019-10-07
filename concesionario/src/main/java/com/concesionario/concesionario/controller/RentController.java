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
import com.concesionario.concesionario.dto.RentDto;
import com.concesionario.concesionario.dto.UserDto;
import com.concesionario.concesionario.entity.CarEntity;
import com.concesionario.concesionario.entity.RentEntity;
import com.concesionario.concesionario.service.CarService;
import com.concesionario.concesionario.service.RentService;
import com.concesionario.concesionario.service.mapper.DtotoRent;
import com.concesionario.concesionario.service.mapper.MapperService;
import com.concesionario.concesionario.service.mapper.RenttoDto;

import javassist.NotFoundException;

@RestController
@RequestMapping("/rent")
public class RentController {
	@Autowired private CarService carService;
	@Autowired private RentService rentService;
	@Autowired private MapperService<RentEntity, RentDto> renttodtoService;
	@Autowired private MapperService<RentDto, RentEntity> dtotorentService;
	
	@PostMapping
	public void save(@RequestBody @Valid RentDto rentdto) throws IllegalArgumentException
	{
		RentEntity rent= new RentEntity();
		rent= dtotorentService.map(rentdto);
		rentService.save(rent);
	}
	@GetMapping
	public Page<RentDto> getAll(@RequestParam(name="page",required=false,defaultValue="0")Pageable page,
			@RequestParam(name="size",required=false,defaultValue="15")Integer size) throws NotFoundException
	{	
		return rentService.getAll(page).map(x-> renttodtoService.map(x));
	}
	@GetMapping("/{id}")
	public RentDto getRent(@PathVariable("id")Integer id) throws NotFoundException
	{
		return renttodtoService.map(rentService.getById(id).get());
	}
	@PutMapping("/{id}")
	public void update(@PathVariable("id") Integer id,@RequestBody RentDto rentdto) throws NotFoundException
	{

		RentEntity rentEntity = new RentEntity();
		rentEntity.setId(id);
		rentEntity=dtotorentService.map(rentdto);
		rentService.update(rentEntity);
	}
	@DeleteMapping
	public void deleteById(@PathVariable("id")Integer id) throws NotFoundException
	{
		rentService.deleteById(id);
	}

	
}
