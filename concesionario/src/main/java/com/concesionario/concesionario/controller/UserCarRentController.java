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

import com.concesionario.concesionario.dto.RentDto;
import com.concesionario.concesionario.entity.RentEntity;
import com.concesionario.concesionario.service.CarService;
import com.concesionario.concesionario.service.UserService;
import com.concesionario.concesionario.service.mapper.DtotoRent;
import com.concesionario.concesionario.service.mapper.MapperService;
import com.concesionario.concesionario.service.mapper.RenttoDto;

@RestController
@RequestMapping("/user/{id}/car/{idcar}/rent")
public class UserCarRentController {
	@Autowired private UserService userService;
	@Autowired private MapperService<RentEntity, RentDto> renttodtoService;
	@Autowired private MapperService<RentDto, RentEntity> dtotorentService;
	@PostMapping
	public void save(@PathVariable("id") Integer id,@PathVariable("idcar") Integer idcar,@RequestBody @Valid RentDto rentdto)
	{
		userService.getById(id).get().getCar().get(idcar).getRent().add(dtotorentService.map(rentdto));
	}
	@GetMapping
	public List<RentDto> getAll(@PathVariable("id") Integer id,@PathVariable("idcar") Integer idcar)
	{	List<RentDto> list = new ArrayList<RentDto>();
		int n= userService.getById(id).get().getCar().get(idcar).getRent().size();
		for (int i = 0; i < n; i++) {
			list.add(renttodtoService.map(userService.getById(id).get().getCar().get(idcar).getRent().get(i)));
		}
		return list;
	}
	@GetMapping("/{idrent}")
	public RentDto getOne(@PathVariable("id") Integer id,@PathVariable("idcar") Integer idcar,@PathVariable("iduser")Integer iduser,
			@PathVariable("idrent")Integer idrent)
	{	
		return renttodtoService.map(userService.getById(id).get().getCar().get(idcar).getRent().get(idrent));
	}
	@PutMapping("/{idrent}")
	public void update(@PathVariable("id")Integer id,
   @PathVariable("idcar") Integer idcar,@PathVariable("idrent")Integer idrent,@RequestBody RentDto rentDto)
	{
		RentEntity rentEntity = new RentEntity();
		rentEntity=dtotorentService.map(rentDto);
		userService.getById(id).get().getCar().get(idcar).getRent().remove(idrent);
		userService.getById(id).get().getCar().get(idcar).getRent().add(dtotorentService.map(rentDto));
		
	}
	@DeleteMapping("/{idrent}")
	public void deleteById(@PathVariable("id")
	Integer id,@PathVariable("idcar")Integer idcar,@PathVariable("idrent")Integer idrent)
	{
		userService.getById(id).get().getCar().get(idcar).getRent().remove(idrent);
	}
}
