package com.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="pets")
@XmlRootElement
public class PetDAO {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) 
	private int id;
    @Column(name="name", length=100)
	private String name;
    @Column(name="owner", length=100)
	private String owner;
    @Column(name="specie", length=100)
	private String specie;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public String getOwner() {
		return owner;
	}
	public String getSpecie() {
		return specie;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public void setSpecie(String specie) {
		this.specie = specie;
	}
	public PetDAO(){
		
	}
	
	public PetDAO(String name, String owner, String specie){
		this.name = name;
		this.owner = owner;
		this.specie = specie;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
