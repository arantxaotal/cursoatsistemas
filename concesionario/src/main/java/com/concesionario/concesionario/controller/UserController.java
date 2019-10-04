package com.concesionario.concesionario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.concesionario.concesionario.service.CarService;
import com.concesionario.concesionario.service.RentService;
import com.concesionario.concesionario.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired private UserService userService;
	@Autowired private CarService carService;
	@Autowired private RentService rentService;
	@GetMapping
	
	
}
