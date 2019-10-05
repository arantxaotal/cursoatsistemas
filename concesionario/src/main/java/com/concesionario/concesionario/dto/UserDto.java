package com.concesionario.concesionario.dto;

import java.util.List;

import com.concesionario.concesionario.entity.CarEntity;
import com.concesionario.concesionario.entity.RentEntity;


public class UserDto {
	private Integer id;
	private String name;
	private List<CarEntity> car;
	private List<RentEntity> rent;
	public UserDto(Integer id, String name, List<CarEntity> car, List<RentEntity> rent) {
		this.id = id;
		this.name = name;
		this.car = car;
		this.rent = rent;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the car
	 */
	public List<CarEntity> getCar() {
		return car;
	}
	/**
	 * @param car the car to set
	 */
	public void setCar(List<CarEntity> car) {
		this.car = car;
	}
	/**
	 * @return the rent
	 */
	public List<RentEntity> getRent() {
		return rent;
	}
	/**
	 * @param rent the rent to set
	 */
	public void setRent(List<RentEntity> rent) {
		this.rent = rent;
	}
	
}
