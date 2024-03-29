package com.esprit.ressources;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;



import com.esprit.busniss.LogementBusiness;
import com.esprit.entities.Logement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("logement")
public class LogementResources  {

	public static LogementBusiness LB = new LogementBusiness();
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response GetAll()
	{
		
		if(LB.getLogements()!=null)
			return Response.status(Response.Status.OK).entity(LB.getLogements()).build();
		
		else 
			
			return Response.status(Response.Status.NOT_FOUND).entity("liste vide" ).build();
	}
	
	
	
	
	
	
	
	
	
	

	
}
