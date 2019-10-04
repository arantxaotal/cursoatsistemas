package com.concesionario.concesionario.dto;

import com.concesionario.concesionario.entity.CarEntity;
import com.concesionario.concesionario.entity.RentEntity;

public class UserDto {
	private Integer id;
	private String name;
	private CarEntity car;
	private RentEntity rent;
	public UserDto(Integer id, String name, CarEntity car, RentEntity rent) {
		super();
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
	public CarEntity getCar() {
		return car;
	}
	/**
	 * @param car the car to set
	 */
	public void setCar(CarEntity car) {
		this.car = car;
	}
	/**
	 * @return the rent
	 */
	public RentEntity getRent() {
		return rent;
	}
	/**
	 * @param rent the rent to set
	 */
	public void setRent(RentEntity rent) {
		this.rent = rent;
	}
	
}
