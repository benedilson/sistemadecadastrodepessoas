package br.com.backend.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.backend.dao.interfaces.OperadorBuscaPorLoginESenha;
import br.com.backend.entidades.Operador;
import br.com.backend.utils.JpaUtils;

@Stateless
public class OperadorDAOImpl implements OperadorBuscaPorLoginESenha {

	private EntityManager em;
	private List<Operador> operadorList = null;
	private Operador operadorTemp = null;

	@Override
	public List<Operador> all() {
		operadorList = new ArrayList<Operador>();
		em = null;
		try {
			em = JpaUtils.getEntityManager();
			operadorList = em.createQuery("from Operador", Operador.class).getResultList();
			return operadorList;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public Operador byId(Long id) {
		Operador resultado = null;
		em = null;
		try {
			em = JpaUtils.getEntityManager();
			resultado = em.find(Operador.class, id);
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return null;
	}

	@Override
	public Operador insert(Operador entity) {
		em = null;
		try {
			em = JpaUtils.getEntityManager();
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();

			return entity;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public Operador update(Operador entity) {
		em = null;
		try {
			em = JpaUtils.getEntityManager();
			em.getTransaction().begin();
			em.merge(entity);
			// em.unwrap(Session.class).update(entity);
			em.getTransaction().commit();

			return entity;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public void delete(Operador entity) {
		em = null;
		try {
			em = JpaUtils.getEntityManager();
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public void deleteById(Long id) {
		em = null;
		try {
			em = JpaUtils.getEntityManager();
			operadorTemp = em.find(Operador.class, id);
			if (operadorTemp != null) {
				em.getTransaction().begin();
				em.remove(operadorTemp);
				em.getTransaction().commit();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public Operador pesquisaPorLoginESenha(String login, String senha) {
		
		em = null;
		
		try {
			em = JpaUtils.getEntityManager();
			operadorTemp = (Operador) em.createQuery("from Operador o where o.loginOperador like concat('%' + :loginOperador + '%') and o.senhaOperador like concat('%' + :senhaOperador + '%') ")
						   .setParameter("loginOperador", login)
						   .setParameter("senhaOperador", senha)
						   .getSingleResult();
			return operadorTemp;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

}