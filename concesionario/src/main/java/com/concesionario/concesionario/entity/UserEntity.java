package com.concesionario.concesionario.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class UserEntity {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@OneToMany(fetch=FetchType.LAZY)
	private List<CarEntity> car;
	@OneToMany(fetch = FetchType.LAZY)
	private List<RentEntity> rent;

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
		 this.car=car;
	}

}
