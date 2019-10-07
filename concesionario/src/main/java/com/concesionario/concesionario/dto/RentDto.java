package com.concesionario.concesionario.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import com.concesionario.concesionario.entity.CarEntity;
import com.concesionario.concesionario.entity.UserEntity;

public class RentDto {
	private Integer id;
	private UserEntity user; 
	private CarEntity car;
	private LocalDate initdate;
	private LocalDate enddate;
	private double price;
	
	public RentDto(Integer id,UserEntity user, CarEntity car, LocalDate initdate, LocalDate enddate, double price) {
		this.id=id;
		this.user = user;
		this.car = car;
		this.initdate = initdate;
		this.enddate = enddate;
		this.price = price;
	}
	
	/**
	 * @return the user
	 */
	public UserEntity getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(UserEntity user) {
		this.user = user;
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
	 * @return the initdate
	 */
	public LocalDate getInitdate() {
		return initdate;
	}
	/**
	 * @param initdate the initdate to set
	 */
	public void setInitdate(LocalDate initdate) {
		this.initdate = initdate;
	}
	/**
	 * @return the enddate
	 */
	public LocalDate getEnddate() {
		return enddate;
	}
	/**
	 * @param enddate the enddate to set
	 */
	public void setEnddate(LocalDate enddate) {
		this.enddate = enddate;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
