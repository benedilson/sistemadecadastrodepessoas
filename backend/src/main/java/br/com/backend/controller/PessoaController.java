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

import br.com.backend.dao.interfaces.GenericoDAO;
import br.com.backend.entidades.Pessoa;

@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("pessoa")
public class PessoaController {

	private Gson gson = new Gson();

	@Inject
	GenericoDAO<Pessoa, Long> servico;

	public PessoaController() {

	}

	@PersistenceContext(unitName = "dev-backend")
	private EntityManager entityManager;

	@GET
	public String all() {
		Type type = new TypeToken<ArrayList<Pessoa>>() {
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
	public Pessoa insert(String entity) {
		try {
			Pessoa pessoa = gson.fromJson(entity, Pessoa.class);
			return servico.insert(pessoa);
		} catch (Exception e) {
			return null;
		}
	}

	@PUT
	@Path("{id}")
	@Consumes("application/json")
	public Pessoa update(@PathParam("id") String id) {
		return servico.update(servico.byId(Long.valueOf(id)));
	}

	@DELETE
	@Path("{id}")
	public void delete(final @PathParam("id") String id) {
		deleteById(Long.valueOf(id));
	}

	public void deleteById(Long id) {
		servico.deleteById(id);
	}

}
