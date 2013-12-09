package se.repos.workarea.webapp;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import se.repos.workarea.WorkAreaConfiguration;
import se.simonsoft.cms.item.CmsRepository;

@Path("/workarea")
// TODO Implement the methods stubs in this class, remove warning suppression.
@SuppressWarnings("all")
public class WorkAreaResource {
    private WorkAreaConfiguration workAreaConfiguration;
    private CmsRepository repository;

    @Inject
    public void setWorkAreaConfiguration(WorkAreaConfiguration workAreaConfiguration) {
        this.workAreaConfiguration = workAreaConfiguration;
    }

    @Inject
    public void setRepository(CmsRepository repository) {
        this.repository = repository;
    }

    @POST
    @Path("{folderName}/upload")
    @Produces(MediaType.APPLICATION_JSON)
    /**
     * @see {@link WorkArea.uploadItems}
     */
    public Response uploadItems(@PathParam("folderName") String folderName,
            @QueryParam("item") List<String> items) {
        // TODO Method stub.
        return null;
    }

    @GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    /**
     * @see {@link WorkArea.getItems}
     */
    public Response getItems() {
        // TODO Method stub.
        return null;
    }

    @GET
    @Path("get-changed")
    @Produces(MediaType.APPLICATION_JSON)
    /**
     * @see {@link WorkArea.getChangedItems}
     */
    public Response getChangedItems() {
        // TODO Method stub.
        return null;
    }

    @POST
    @Path("commit")
    @Produces(MediaType.APPLICATION_JSON)
    /**
     * @see {@link WorkArea.commitItems}
     */
    public Response commitItems(@QueryParam("comment") String comment,
            @QueryParam("entry") List<String> entry) {
        // TODO Method stub.
        return null;
    }
}
