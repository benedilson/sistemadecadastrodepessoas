package br.com.backend.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.backend.dao.interfaces.GenericoDAORemote;
import br.com.backend.dao.interfaces.OperadorBuscaPorLoginESenha;
import br.com.backend.entidades.Operador;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/operador")
public class OperadorController {

	private Gson gson = new Gson();

	@Inject
	GenericoDAORemote<Operador, Long> servico;
	
	@Inject
	OperadorBuscaPorLoginESenha busca;
	

	public OperadorController() {

	}

	@PersistenceContext(unitName = "dev-backend")
	private EntityManager entityManager;
	
	@GET
	public String all() {
		Type type = new TypeToken<ArrayList<Operador>>() {
		}.getType();
		return gson.toJson(servico.all(), type);
	}

	@GET
	@Path("{id}")
	public String byId(@PathParam("id") String id) {
		return gson.toJson(servico.byId(Long.valueOf(id)));
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Operador insert(String entity) {
		try {
			Operador operador = gson.fromJson(entity, Operador.class);
			return servico.insert(operador);
		} catch (Exception e) {
			return null;
		}
	}

	@PUT
	@Path("{id}")
	@Consumes("application/json")
	public Operador update(@PathParam("id") String id) {
		return servico.update(servico.byId(Long.valueOf(id)));
	}

	@DELETE
	@Path("{id}")
	public void delete(final @PathParam("id") String id) {
		deleteById(Long.valueOf(id));
	}

	@GET
	@Path("{login/senha}")
	public String buscaPorLoginESEnha(final @PathParam("login") String login, @PathParam("senha")  String senha) {
		return gson.toJson(buscaPorLoginESEnha(login, senha));
	}
	
	public void deleteById(Long id) {
		servico.deleteById(id);
	}

}
