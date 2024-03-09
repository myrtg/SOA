package resources;

import Business.StageBusiness;
import Entities.Etudiant;
import Entities.Stage;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
@Path("/stages")
public class stagesresources {

        private StageBusiness stageBusiness = new StageBusiness();

        @GET
        @Path("/all")
        @Produces(MediaType.APPLICATION_JSON)
        public List<Stage> getAllStages() {
            return stageBusiness.getAllStages();
        }

        @GET
        @Path("/{stageId}")
        @Produces(MediaType.APPLICATION_JSON)
        public Stage getStageById(@PathParam("stageId") int stageId) {
            return stageBusiness.getStageById(stageId);
        }


        @DELETE
        @Path("/{stageId}")
        public void deleteStage(@PathParam("stageId") int stageId) {
            stageBusiness.deleteStage(stageId);
        }


    }




