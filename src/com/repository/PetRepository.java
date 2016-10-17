package com.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.dao.PetDAO;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PetRepository {
	
	EntityManager entitymanager;
	
	public PetRepository(){
		try {
			entitymanager = Repository.getEntityManagetFactory().createEntityManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<PetDAO> getAllPets(){
		Query query = entitymanager.createQuery("SELECT p FROM PetDAO p");
		@SuppressWarnings(value = {"unchecked"})
		List<PetDAO> pets = (List<PetDAO>) query.getResultList(); 
		return pets;
	}
	
	public PetDAO createPet(PetDAO pet) {
		entitymanager.getTransaction().begin();
	    entitymanager.persist(pet);
	    entitymanager.getTransaction().commit();
	    return pet;
	}
	
	public boolean updatePet(PetDAO pet) {
		PetDAO oldPet = entitymanager.find(PetDAO.class, pet.getId());
		
		if (oldPet != null){
			entitymanager.getTransaction().begin();
			oldPet.setName(pet.getName());
			oldPet.setOwner(pet.getOwner());
			oldPet.setSpecie(pet.getSpecie());
			entitymanager.getTransaction().commit();
			return true;
		}
	    return false;
	}
	
	public boolean removePet(int id){
		PetDAO pet = entitymanager.find(PetDAO.class, id);
	    if (pet != null) {
	    	entitymanager.getTransaction().begin();
	        entitymanager.remove(pet);
	        entitymanager.getTransaction().commit();
	        return false;
	    }
	    return true;
	}
}
