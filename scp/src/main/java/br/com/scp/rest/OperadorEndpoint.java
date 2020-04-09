package br.com.scp.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

import br.com.scp.model.Operador;

/**
 * 
 */
@Stateless
@Path("/operadors")
public class OperadorEndpoint {
	
	@PersistenceContext(unitName = "java:jboss/datasources/scpDS")
	private EntityManager em;

	@POST
	@Consumes("application/json")
	public Response create(Operador entity) {
		em.persist(entity);
		return Response.created(
				UriBuilder.fromResource(OperadorEndpoint.class)
						.path(String.valueOf(entity.getId())).build()).build();
	}

	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") Long id) {
		Operador entity = em.find(Operador.class, id);
		if (entity == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		em.remove(entity);
		return Response.noContent().build();
	}

	@GET
	@Path("/{login:[A-Za-z\\\\-\\\\_]*}/{senha:[A-Za-z\\\\\\\\-\\\\\\\\_]*}")
	@Produces("application/json")
	public Response findByLoginAndPessword(@PathParam("login") String login, @PathParam("senha") String senha) {
		TypedQuery<Operador> findByIdQuery = em
				.createQuery(
						"SELECT DISTINCT o FROM Operador o WHERE o.login = :entityLogin and o.senha = :entitySenha",
						Operador.class);
		findByIdQuery.setParameter("entityLogin", login);
		findByIdQuery.setParameter("entitySenha", senha);
		Operador entity;
		try {
			entity = findByIdQuery.getSingleResult();
		} catch (NoResultException nre) {
			entity = null;
		}
		if (entity == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(entity).build();
	}
	
	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces("application/json")
	public Response findById(@PathParam("id") Long id) {
		TypedQuery<Operador> findByIdQuery = em
				.createQuery(
						"SELECT DISTINCT o FROM Operador o WHERE o.id = :entityId ORDER BY o.id",
						Operador.class);
		findByIdQuery.setParameter("entityId", id);
		Operador entity;
		try {
			entity = findByIdQuery.getSingleResult();
		} catch (NoResultException nre) {
			entity = null;
		}
		if (entity == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(entity).build();
	}

	@GET
	@Produces("application/json")
	public List<Operador> listAll(@QueryParam("start") Integer startPosition,
			@QueryParam("max") Integer maxResult) {
		TypedQuery<Operador> findAllQuery = em.createQuery(
				"SELECT DISTINCT o FROM Operador o ORDER BY o.id",
				Operador.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		final List<Operador> results = findAllQuery.getResultList();
		return results;
	}

	@PUT
	@Path("/{id:[0-9][0-9]*}")
	@Consumes("application/json")
	public Response update(@PathParam("id") Long id, Operador entity) {
		if (entity == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (id == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (!id.equals(entity.getId())) {
			return Response.status(Status.CONFLICT).entity(entity).build();
		}
		if (em.find(Operador.class, id) == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		try {
			entity = em.merge(entity);
		} catch (OptimisticLockException e) {
			return Response.status(Response.Status.CONFLICT)
					.entity(e.getEntity()).build();
		}

		return Response.noContent().build();
	}
}
