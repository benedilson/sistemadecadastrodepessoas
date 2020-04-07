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

import br.com.backend.entidades.Pessoa;
import br.com.backend.services.PessoaServices;

@Path("/")
public class PessoaController {
	
	@EJB
	PessoaServices servico;
	
	@GET
	@Path("pessoa")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pessoa> all() {
		return servico.all();
	}
	
	@GET
	@Path("pessoa/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Pessoa byId(@QueryParam("id") Long id) {
		return servico.byId(id);
	}
	
	@POST
	@Path("pessoa")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Pessoa insert(@FormParam("pessoa") Pessoa entity) {
		return servico.insert(entity);
	}
	
	@PUT
	@Path("pessoa/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Pessoa update(@QueryParam("id") Long id) {
		return servico.update(servico.byId(id));
	}
	
	@DELETE
	@Path("Pessoa/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void delete(@QueryParam("id") Long id) {
		deleteById(id);
	}
	
	public void deleteById(Long id) {
		servico.deleteById(id);
	}
	
}
