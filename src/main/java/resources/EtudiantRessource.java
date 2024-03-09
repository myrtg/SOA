package resources;

import Business.EtudiantBusiness;
import Entities.Etudiant;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("Etudiant")
public class EtudiantRessource {
    public static EtudiantBusiness EB = new EtudiantBusiness();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{stageID}")
    public Response findbyStageId(@QueryParam(value="stageID") Integer id)
    {
        if (id != null)
        {
            if (EB.getStudentsByStageId(id)!=null)
            {
                List<Etudiant> list = new ArrayList<Etudiant>();
                list = EB.getStudentsByStageId(id);
                return Response.status(Response.Status.OK).entity(list).build();
            }
            else {
                return Response.status(Response.Status.NOT_FOUND).entity("impossible de trouver").build();
            }
        }
        return Response.status(Response.Status.OK).entity(EB.getAllEtudiants()).build();
    }
}







