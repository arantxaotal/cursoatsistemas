package com.concesionario.concesionario.dto;

import java.time.LocalTime;
import java.util.Date;

import com.concesionario.concesionario.entity.CarEntity;
import com.concesionario.concesionario.entity.UserEntity;

public class RentDto {
	private UserEntity user; 
	private CarEntity car;
	private LocalTime initdate;
	private LocalTime enddate;
	private double price;
	
	public RentDto(UserEntity user, CarEntity car, LocalTime initdate, LocalTime enddate, double price) {
		
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
	public LocalTime getInitdate() {
		return initdate;
	}
	/**
	 * @param initdate the initdate to set
	 */
	public void setInitdate(LocalTime initdate) {
		this.initdate = initdate;
	}
	/**
	 * @return the enddate
	 */
	public LocalTime getEnddate() {
		return enddate;
	}
	/**
	 * @param enddate the enddate to set
	 */
	public void setEnddate(LocalTime enddate) {
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

}
