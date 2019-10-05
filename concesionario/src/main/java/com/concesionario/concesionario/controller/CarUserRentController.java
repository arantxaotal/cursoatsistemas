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
import com.concesionario.concesionario.dto.UserDto;
import com.concesionario.concesionario.entity.RentEntity;
import com.concesionario.concesionario.entity.UserEntity;
import com.concesionario.concesionario.service.CarService;
import com.concesionario.concesionario.service.mapper.DtotoRent;
import com.concesionario.concesionario.service.mapper.DtotoUser;
import com.concesionario.concesionario.service.mapper.RenttoDto;
import com.concesionario.concesionario.service.mapper.UsertoDto;

@RestController
@RequestMapping("/car/{id}/user/{iduser}/rent")
public class CarUserRentController {
	@Autowired private CarService carService;
	@Autowired private RenttoDto renttodtoService;
	@Autowired private DtotoRent dtotorentService;
	@PostMapping
	public void save(@PathVariable("id") Integer id,@PathVariable("iduser") Integer iduser,@RequestBody @Valid RentDto rentdto)
	{
		carService.getById(id).get().getUser().getRent().add(dtotorentService.map(rentdto));
	}
	@GetMapping
	public List<RentDto> getAll(@PathVariable("id") Integer id,@PathVariable("iduser") Integer iduser)
	{	List<RentDto> list = new ArrayList<RentDto>();
		int n= carService.getById(id).get().getUser().getRent().size();
		for (int i = 0; i < n; i++) {
			list.add(renttodtoService.map(carService.getById(id).get().getUser().getRent().get(i)));
		}
		return list;
	}
	@GetMapping("/{idrent}")
	public RentDto getOne(@PathVariable("id") Integer id,@PathVariable("iduser") Integer iduser,@PathVariable("idcar")Integer idcar,
			@PathVariable("idrent")Integer idrent)
	{	
		return renttodtoService.map(carService.getById(id).get().getUser().getRent().get(idrent));
	}
	@PutMapping("/{idrent}")
	public void update(@PathVariable("id")Integer id,
   @PathVariable("iduser") Integer iduser,@PathVariable("idrent")Integer idrent,@RequestBody RentDto rentDto)
	{
		RentEntity rentEntity = new RentEntity();
		rentEntity=dtotorentService.map(rentDto);
		carService.getById(id).get().getUser().getRent().remove(idrent);
		carService.getById(id).get().getUser().getRent().add(dtotorentService.map(rentDto));
		
	}
	@DeleteMapping("/{idrent}")
	public void deleteById(@PathVariable("id")
	Integer id,@PathVariable("iduser")Integer iduser,@PathVariable("idrent")Integer idrent)
	{
		carService.getById(id).get().getUser().getRent().remove(idrent);
	}
}
