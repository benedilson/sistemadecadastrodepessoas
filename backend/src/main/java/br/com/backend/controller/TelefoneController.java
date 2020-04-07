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

import br.com.backend.entidades.Telefone;
import br.com.backend.services.TelefoneServices;

@Path("/")
public class TelefoneController {
	
	@EJB
	TelefoneServices servico;
	
	@GET
	@Path("telefone")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Telefone> all() {
		return servico.all();
	}
	
	@GET
	@Path("telefone/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Telefone byId(@QueryParam("id") Long id) {
		return servico.byId(id);
	}
	
	@POST
	@Path("telefone")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Telefone insert(@FormParam("telefone") Telefone entity) {
		return servico.insert(entity);
	}
	
	@PUT
	@Path("telefone/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Telefone update(@QueryParam("id") Long id) {
		return servico.update(servico.byId(id));
	}
	
	@DELETE
	@Path("telefone/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void delete(@QueryParam("id") Long id) {
		deleteById(id);
	}
	
	public void deleteById(Long id) {
		servico.deleteById(id);
	}
	
}
