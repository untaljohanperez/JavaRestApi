package com.apicontroller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dao.PetDAO;
import com.repository.PetRepository;
import com.sun.jersey.api.JResponse;


@Path("/pets")
public class PetController {
	
	PetRepository petRepository;
	
	public PetController() {
		petRepository = new PetRepository();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public JResponse<List<PetDAO>> getPets(){
			List<PetDAO> pets = petRepository.getAllPets(); 
			return JResponse.ok(pets).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postPet(PetDAO pet){
		try {
			PetDAO petResponse = petRepository.createPet(pet);
			return Response.status(Response.Status.CREATED).entity(petResponse).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.toString()).build();
		}
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response putPet(PetDAO pet){
		try {
			petRepository.updatePet(pet);
			return Response.ok().entity(pet).build();	
		} catch (Exception e) {
			return Response.serverError().entity(e.toString()).build();
		}
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response deletePet(@PathParam("id") int id){
		try {
			petRepository.removePet(id);
			return Response.noContent().build();	
		} catch (Exception e) {
			return Response.serverError().entity(e.toString()).build();
		}
	}
}
