package com.concesionario.concesionario.dto;

import java.util.ArrayList;
import java.util.List;

import com.concesionario.concesionario.entity.RentEntity;
import com.concesionario.concesionario.entity.UserEntity;

public class CarDto {
	
	private Integer id;
	private String model;
	private String brand;
	private UserEntity user;
	private List<RentEntity> rent=new ArrayList<RentEntity>();
	
	public CarDto(Integer id, String model, String brand, UserEntity user, List<RentEntity> rent) {
		this.id = id;
		this.model = model;
		this.brand = brand;
		this.user = user;
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
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
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
