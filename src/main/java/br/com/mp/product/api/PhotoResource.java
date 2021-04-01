package br.com.mp.product.api;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.mp.product.model.PhotoDTO;
import br.com.mp.product.repository.PhotoRepository;

@Path("/photo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PhotoResource {

    @Inject
    private PhotoRepository photoRepository;

    @GET
    public Response findAll() {
        return Response.ok(photoRepository.list()).build();
    }

    @GET
    @Path("{id}")
    public Response findById(@PathParam("id") Integer id) {
        return Response.ok(photoRepository.findById(id.longValue())).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Integer id, PhotoDTO photoDTO) {
        return Response.ok(photoRepository.update(id.longValue(), photoDTO)).build();
    }

    @POST
    @Path("/upload")
    public Response fileUpload(PhotoDTO data) {
        return Response.ok(photoRepository.save(data)).build();
    }

}
