package com.concesionario.concesionario.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;



@Entity
@Table(name = "User")
public class UserEntity {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@OneToMany(fetch=FetchType.LAZY,mappedBy = "user")
	@JsonIgnore
	private List<CarEntity> car=new ArrayList<CarEntity>();
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
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
	@JsonIgnore
	public List<CarEntity> getCar() {
		return car;
	}
	/**
	 * @param car the car to set
	 */
	@JsonProperty
	public void setCar(List<CarEntity> car) {
		 this.car=car;
	}

}
