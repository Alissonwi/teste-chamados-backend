package com.teste.chamado.rest;
import java.sql.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.teste.chamado.entity.Chamado;
import com.teste.chamado.entity.EntityManagerHelper;

@javax.inject.Singleton
@Path("Chamado")
public class ChamadoFacadeREST extends AbstractFacade<Chamado> {
	private EntityManager em;
	public ChamadoFacadeREST() {
		super(Chamado.class);
	}
	
	@GET
	@Path("update/{id}/{status}")
	@Consumes({ "application/xml", "application/json" })
	public Response edit(@PathParam("id") Integer id, @PathParam("status") Boolean status) {
		Chamado chamado = super.find(id);
		chamado.setStatus(status);
		if(status) {
			chamado.setDataConclusao(new Date(System.currentTimeMillis()));
		} else {
			chamado.setDataConclusao(null);
		}
		return super.edit(chamado);
	}
	
	@POST
	@Override
	@Consumes({ "application/xml", "application/json" })
	public Response create(Chamado entity) {
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
	public Chamado find(@PathParam("id") Integer id) {
		return super.find(id);
	}

	@GET
	@Override
	@Produces({ "application/json" })
	public List<Chamado> findAll() {
		return super.findAll();
	}

	@GET
	@Path("{from}/{to}")
	@Produces({ "application/xml", "application/json" })
	public List<Chamado> findRange(@PathParam("from") Integer from,
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
}
	