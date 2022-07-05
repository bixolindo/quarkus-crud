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

import br.com.mp.product.model.Creche;
import br.com.mp.product.repository.CrecheRepository;

@Path("/creche")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CrecheResource {

	@Inject
	CrecheRepository crecheRepository;

	@GET
	public List<Creche> list() {
		return crecheRepository.list();
	}

	@GET
	@Path("{id}")
	public Response getByID(@PathParam("id") Long id) {
		return Response.ok(crecheRepository.findId(id)).status(Response.Status.OK).build();
	}

	@POST
	public Response create(@Valid Creche creche) {
		Creche crecheEntity = crecheRepository.save(creche);
		return Response.ok(crecheEntity).status(Response.Status.CREATED).build();
	}
	
	@PUT
	@Path("{id}")
	public Response update(@PathParam("id") Long id, Creche creche) {
		System.err.println("aqui");
		Creche crecheEntity = crecheRepository.update(id, creche);
		return Response.ok(crecheEntity).status(Response.Status.CREATED).build();
	}

	@DELETE
	@Path("{id}")
	public Response remove(@PathParam("id") Long id) {
		crecheRepository.remove(id);
		return Response.status(Response.Status.NO_CONTENT).build();
	}
}
