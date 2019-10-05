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

import com.concesionario.concesionario.dto.RentDto;
import com.concesionario.concesionario.entity.CarEntity;
import com.concesionario.concesionario.entity.RentEntity;
import com.concesionario.concesionario.service.CarService;
import com.concesionario.concesionario.service.RentService;
import com.concesionario.concesionario.service.mapper.DtotoRent;
import com.concesionario.concesionario.service.mapper.RenttoDto;

import javassist.NotFoundException;

@RestController
@RequestMapping("/car/{id}/rent")
public class RentController {
	@Autowired private CarService carService;
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
	@GetMapping
	public RentDto getById(@PathVariable("id") Integer id,@PathVariable("idrent")Integer idrent)
	{
		List<RentEntity> rent= new ArrayList<RentEntity>();
		rent= carService.getById(id).get().getRent();
		return renttodtoService.map(rent.get(idrent));

	}
	@PutMapping("/{idrent}")
	public void update(@PathVariable("id") Integer id,@PathVariable("idrent")Integer idrent,@RequestBody RentDto rentdto)
	{
		List<RentEntity> rent= new ArrayList<RentEntity>();
		rent= carService.getById(id).get().getRent();
		RentEntity rentEntity = new RentEntity();
		rentEntity.setId(rent.get(idrent).getId());
		rentEntity=dtotorentService.map(rentdto);
		rentService.update(rentEntity);
	}
	@DeleteMapping
	public void deleteById(@PathVariable("idrent")Integer id)
	{
		rentService.deleteById(id);
	}
	
}
