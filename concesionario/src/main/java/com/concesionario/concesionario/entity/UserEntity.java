package com.concesionario.concesionario.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class UserEntity {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@OneToMany(fetch=FetchType.LAZY)
	private CarEntity car;
	@ManyToOne(fetch = FetchType.LAZY)
	private RentEntity rent;

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

}
