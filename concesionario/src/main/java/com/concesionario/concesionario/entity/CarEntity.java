package com.concesionario.concesionario.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;



@Entity
@Table(name = "Car")
public class CarEntity {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Integer id;
	private String model;
	private String brand;
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private UserEntity user;
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "car")
	@JsonIgnore
	private List<RentEntity> rent=new ArrayList<RentEntity>();

	/**
	 * @return the rent
	 */
	@JsonIgnore
	public List<RentEntity> getRent() {
		return rent;
	}
	/**
	 * @param rent the rent to set
	 */
	@JsonProperty
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
	

}
