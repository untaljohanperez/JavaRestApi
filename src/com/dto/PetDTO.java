package com.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="pets")
public class PetDTO{
	private String name;
	private String owner;
	private String specie;
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
	public PetDTO(String name, String owner, String specie){
		this.name = name;
		this.owner = owner;
		this.specie = specie;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	public PetDTO(){}
}
