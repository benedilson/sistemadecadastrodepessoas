package br.com.backend.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.backend.entidades.Operador;
import br.com.backend.services.OperadorServices;

@Path("/")
public class OperadorController {
	
	@EJB
	OperadorServices servico;
	
	@GET
	@Path("operador")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Operador> all() {
		return servico.all();
	}
	
	@GET
	@Path("operador/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Operador byId(@QueryParam("id") Long id) {
		return servico.byId(id);
	}
	
	@POST
	@Path("operador")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Operador insert(@FormParam("operador") Operador entity) {
		return servico.insert(entity);
	}
	
	@PUT
	@Path("operador/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Operador update(@QueryParam("id") Long id) {
		return servico.update(servico.byId(id));
	}
	
	@DELETE
	@Path("operador/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void delete(@QueryParam("id") Long id) {
		deleteById(id);
	}
	
	public void deleteById(Long id) {
		servico.deleteById(id);
	}
	
}
