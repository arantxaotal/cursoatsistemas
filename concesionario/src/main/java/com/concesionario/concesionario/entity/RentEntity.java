package com.concesionario.concesionario.entity;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name="Rent")
public class RentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne(fetch=FetchType.LAZY)
	private UserEntity user; 
	@ManyToOne(fetch=FetchType.LAZY)
	private CarEntity car;
	private LocalTime initdate;
	private LocalTime enddate;
	private double price;

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
