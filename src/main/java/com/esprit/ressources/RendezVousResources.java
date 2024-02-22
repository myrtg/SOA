package com.esprit.ressources;

import java.util.ArrayList;
import java.util.List;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.esprit.busniss.LogementBusiness;
import com.esprit.busniss.RendezVousBusiness;
import com.esprit.entities.RendezVous;




@Path("rendezvous")
public class RendezVousResources {

	private static RendezVousBusiness RB = new RendezVousBusiness();
	public static LogementBusiness logementMetier = new LogementBusiness();
	RendezVous r = new RendezVous(1, "31-10-2015", "15:30",
			logementMetier.getLogementsByReference(4), "55214078");


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListRDV() {
		if (RB.getListeRendezVous().size() != 0) {
			return Response.status(Status.OK).entity(RB.getListeRendezVous()).build();

		}

		return Response.status(Status.NOT_FOUND).entity("La liste est vide").build();

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addRendezVous(RendezVous r) {
		if (RB.addRendezVous(r)) {
			return Response.status(Status.CREATED).entity("added successfully").build();
		} else {
			return Response.status(Status.NOT_FOUND).entity("Echo not fount").build();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response getDetails(@PathParam(value = "id") int id) {
		RendezVous r = RB.getRendezVousById(id);
		return Response.status(Status.OK).entity(r).build();
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response deleteDetaimls(@PathParam(value = "id") int id) {
		RendezVous r = RB.getRendezVousById(id);
		return Response.status(Status.FOUND).entity("RDV supprimé").build();
	}
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response updateRdv(@PathParam(value="id") int id,RendezVous r)
	{
		if (RB.updateRendezVous(id,r))
		{
			return Response.status(Status.OK).entity("updated successfully").build();
		}
		else{
			return Response.status(Status.NOT_FOUND).entity("Not found ").build();
		}
	}
}