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
import com.concesionario.concesionario.entity.CarEntity;
import com.concesionario.concesionario.entity.RentEntity;
import com.concesionario.concesionario.service.CarService;
import com.concesionario.concesionario.service.RentService;
import com.concesionario.concesionario.service.mapper.CarttoDto;
import com.concesionario.concesionario.service.mapper.DtotoCar;
import com.concesionario.concesionario.service.mapper.DtotoRent;
import com.concesionario.concesionario.service.mapper.MapperService;
import com.concesionario.concesionario.service.mapper.RenttoDto;

@RestController
@RequestMapping("/rent/{id}/user/{iduser}/car")
public class RentUserCarController {
	@Autowired private RentService rentService;
	@Autowired private MapperService<CarEntity, CarDto> cartodtoService;
	@Autowired private MapperService<CarDto, CarEntity> dtotocarService;
	@PostMapping
	public void save(@PathVariable("id") Integer id,@PathVariable("iduser") Integer iduser,@RequestBody @Valid CarDto cardto)
	{
		rentService.getById(id).get().getUser().getCar().add(dtotocarService.map(cardto));
	}
	@GetMapping
	public List<CarDto> getAll(@PathVariable("id") Integer id,@PathVariable("iduser") Integer iduser)
	{	List<CarDto>list=new ArrayList<CarDto>();
		int n= rentService.getById(id).get().getUser().getRent().size();
		for (int i = 0; i < n; i++) {
			list.add(cartodtoService.map(rentService.getById(id).get().getUser().getCar().get(i)));
		}
		return list;
	}
	@GetMapping("/{idcar}")
	public CarDto getOne(@PathVariable("id") Integer id,@PathVariable("iduser") Integer iduser,@PathVariable("idcar")Integer idcar)
	{	
		return cartodtoService.map(rentService.getById(id).get().getUser().getCar().get(idcar));

	}
	@PutMapping("/{idcar}")
	public void update(@PathVariable("id")Integer id,
   @PathVariable("iduser") Integer iduser,@PathVariable("idcar")Integer idcar,@RequestBody CarDto carDto)
	{
		CarEntity carEntity = new CarEntity();
		carEntity=dtotocarService.map(carDto);
		rentService.getById(id).get().getUser().getCar().remove(idcar);
		rentService.getById(id).get().getUser().getCar().add(dtotocarService.map(carDto));
		
	}
	@DeleteMapping("/{idcar}")
	public void deleteById(@PathVariable("id")
	Integer id,@PathVariable("iduser")Integer iduser,@PathVariable("idcar")Integer idcar)
	{
		rentService.getById(id).get().getUser().getCar().remove(idcar);
	}
}
