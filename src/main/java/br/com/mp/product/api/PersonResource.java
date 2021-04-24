package br.com.mp.product.api;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
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

import br.com.mp.product.model.PersonDTO;
import br.com.mp.product.repository.PersonRepository;

@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {

    @Inject
    PersonRepository personRepository;

    @GET
    public List<PersonDTO> list() {
        return personRepository.list();
    }

    @GET
    @Path("{id}")
    public Response getByID(@PathParam("id") Long id) {
        return Response.ok(personRepository.findId(id)).status(Response.Status.OK).build();
    }

    @POST
    public Response create(@Valid PersonDTO person) {
        PersonDTO personEntity = personRepository.save(person);
        return Response.ok(personEntity).status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, PersonDTO person) {
        PersonDTO personUpdated = personRepository.update(id, person);

        return Response.ok(personUpdated).build();
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") Long id) {
        personRepository.remove(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
