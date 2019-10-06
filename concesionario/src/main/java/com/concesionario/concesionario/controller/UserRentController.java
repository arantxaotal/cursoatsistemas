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

import com.concesionario.concesionario.dto.RentDto;
import com.concesionario.concesionario.entity.RentEntity;
import com.concesionario.concesionario.entity.UserEntity;
import com.concesionario.concesionario.service.RentService;
import com.concesionario.concesionario.service.UserService;
import com.concesionario.concesionario.service.mapper.RenttoDto;
import com.concesionario.concesionario.service.mapper.DtotoRent;
import com.concesionario.concesionario.service.mapper.MapperService;

@RestController
@RequestMapping("/user/{id}/rent")
public class UserRentController {
	@Autowired private RentService rentService;
	@Autowired private MapperService<RentEntity, RentDto> renttodtoService;
	@Autowired private MapperService<RentDto, RentEntity> dtotorentService;
	@Autowired private UserService userService;
	@PostMapping
	public void save(@PathVariable("id") Integer id,@RequestBody @Valid RentDto rentdto)
	{
		userService.getById(id).get().getRent().add(dtotorentService.map(rentdto));
	}
	@GetMapping
	public List<RentDto> getAll(@PathVariable("id") Integer id)
	{	
		List<RentDto> rentlistDtos = new ArrayList<RentDto>();
		int n =userService.getById(id).get().getRent().size();
		for (int i = 0; i < n; i++) {
			rentlistDtos.add(renttodtoService.map(userService.getById(id).get().getRent().get(i)));
		}
		return rentlistDtos;
	}	
	@GetMapping("/{idrent}")
	public RentDto getOne(@PathVariable("idrent") Integer idrent,@RequestParam(name = "id")Integer id) 
	{
		return renttodtoService.map(userService.getById(id).get().getRent().get(idrent));
		
	}
	@PutMapping("/{idrent}")
	public void update(@PathVariable("id") Integer id,@PathVariable("idrent")Integer idrent,@RequestBody RentDto rentdto)
	{		RentEntity rentEntity= dtotorentService.map(rentdto);
			userService.getById(id).get().getRent().remove(idrent);
			userService.getById(id).get().getRent().add(rentEntity);	
	}
	@DeleteMapping("/{idrent}")
	public void deleteById(@PathVariable("id")Integer id,@PathVariable("idrent")Integer idrent)
	{
		userService.getById(id).get().getRent().remove(idrent);
	}
}
