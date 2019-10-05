package com.concesionario.concesionario.controller;

import java.util.List;

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

import com.concesionario.concesionario.dto.RentDto;
import com.concesionario.concesionario.entity.RentEntity;
import com.concesionario.concesionario.service.RentService;
import com.concesionario.concesionario.service.mapper.DtotoRent;
import com.concesionario.concesionario.service.mapper.RenttoDto;

import javassist.NotFoundException;

@RestController
@RequestMapping("/car/{id}/rent")
public class RentController {
	@Autowired private RentService rentService;
	@Autowired private RenttoDto renttodtoService;
	@Autowired private DtotoRent dtotorentService;
	@PostMapping
	public void save(@RequestBody @Valid RentDto rentdto)
	{
		RentEntity rent= new RentEntity();
		rent= dtotorentService.map(rentdto);
		rentService.save(rent);
	}
	@GetMapping("/{id}")
	public RentDto getById(@PathVariable("id") Integer id) throws NotFoundException
	{
		RentEntity rent= new RentEntity();
		rent= rentService.getById(id).orElseThrow(()->new NotFoundException("Usuario no encontrado Error-404"));
		return renttodtoService.map(rent);
	}
	@GetMapping
	public Page<RentDto> getAll(@RequestParam(name="page",required=false,defaultValue="0")Integer page,
			@RequestParam(name="size",required=false,defaultValue="15")Integer size)
	{
	    Pageable pageable= PageRequest.of(page,size);
		Page<RentDto>rent=rentService.getAll(pageable).map(x-> renttodtoService.map(x));
		return rent;
	}
	@PutMapping
	public void update(@PathVariable("id") Integer id,@RequestBody RentDto rentdto)
	{
		RentEntity rent= new RentEntity();
		rent.setId(id);
		rent= dtotorentService.map(rentdto);
		rentService.update(rent);
	}
	@DeleteMapping
	public void deleteById(@PathVariable("id")Integer id)
	{
		rentService.deleteById(id);
	}
	
}
