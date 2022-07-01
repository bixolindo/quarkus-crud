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

import br.com.mp.product.model.CriancaDTO;

import br.com.mp.product.repository.CriancaRepository;

@Path("/crianca")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CriancaResource {

	@Inject
	CriancaRepository criancaRepository;

	@GET
	public List<CriancaDTO> list() {
		return criancaRepository.list();
	}

	@GET
	@Path("{id}")
	public Response getByID(@PathParam("id") Long id) {
		return Response.ok(criancaRepository.findId(id)).status(Response.Status.OK).build();
	}

	@POST
	public Response create(@Valid CriancaDTO crianca) {
		CriancaDTO criancaEntity = criancaRepository.save(crianca);
		return Response.ok(criancaEntity).status(Response.Status.CREATED).build();
	}

	@PUT
	@Path("{id}")
	public Response update(@PathParam("id") Long id, CriancaDTO person) {
		CriancaDTO criancaUpdated = criancaRepository.update(id, person);
		return Response.ok(criancaUpdated).build();
	}

	@DELETE
	@Path("{id}")
	public Response remove(@PathParam("id") Long id) {
		criancaRepository.remove(id);
		return Response.status(Response.Status.NO_CONTENT).build();
	}
}
