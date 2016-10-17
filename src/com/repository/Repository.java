package com.repository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Repository {
	  private static final String PERSISTENCE_UNIT_NAME = "Rest";
	  protected static EntityManagerFactory factory = null;
	  
	  public static EntityManagerFactory getEntityManagetFactory(){
		  if(factory == null){
			  factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		  }
		  return factory;
	  }
}
