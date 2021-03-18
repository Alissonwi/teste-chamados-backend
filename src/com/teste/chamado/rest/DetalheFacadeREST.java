package com.teste.chamado.rest;
import java.util.List;
import javax.persistence.EntityManager;
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
import javax.ws.rs.core.Response.Status;

import com.teste.chamado.entity.Detalhe;
import com.teste.chamado.entity.EntityManagerHelper;

@javax.inject.Singleton
@Path("Detalhe")
public class DetalheFacadeREST  extends AbstractFacade<Detalhe>  {
	private EntityManager em;
	public DetalheFacadeREST() {
		super(Detalhe.class);
	}
	
	@PUT
	@Override
	@Consumes({ "application/xml", "application/json" })
	public Response edit(Detalhe entity) {
		if (entity.getComentario().length() <= 3) {
			return Response.status(Status.CONFLICT).entity("Customer name is too short").type(MediaType.TEXT_PLAIN).build();
		}
		return super.edit(entity);
	}
	
	@POST
	@Override
	@Consumes({ "application/xml", "application/json" })
	public Response create(Detalhe entity) {
		return super.create(entity);
	}
	
	@DELETE
	@Path("remove/{id}")
	public Response remove(@PathParam("id") Integer id) {
		return super.remove(super.find(id));
	}
	@GET
	@Path("{id}")
	@Produces({ "application/json" })
	public Detalhe find(@PathParam("id") Integer id) {
		return super.find(id);
	}

	@GET
	@Override
	@Produces({ "application/json" })
	public List<Detalhe> findAll() {
		return super.findAll();
	}

	@GET
	@Path("{from}/{to}")
	@Produces({ "application/xml", "application/json" })
	public List<Detalhe> findRange(@PathParam("from") Integer from,
			@PathParam("to") Integer to) {
		return super.findRange(new int[] { from, to });
	}

	@GET
	@Path("count")
	@Produces("text/plain")
	public String countREST() {
		return String.valueOf(super.count());
	}

	@Override
	protected EntityManager getEntityManager() {
		em = EntityManagerHelper.getEntityManager();
		return em;
	}
	
	@GET
	@Path("Chamado/{id}")
	@Produces({ "application/json" })
	public List<Detalhe> findDetalhesFromChamado(@PathParam("id") Integer id) {
		return super.findDetalhesFromChamado(id);
	}
}
