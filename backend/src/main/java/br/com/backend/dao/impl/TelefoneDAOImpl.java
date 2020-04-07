package br.com.backend.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.backend.dao.interfaces.GenericoDAO;
import br.com.backend.entidades.Telefone;
import br.com.backend.utils.JpaUtils;

public class TelefoneDAOImpl implements GenericoDAO<Telefone, Long> {

	private EntityManager em;
	private List<Telefone> TelefoneList = null;
	private Telefone TelefoneTemp = null;

	@Override
	public List<Telefone> all() {
		TelefoneList = new ArrayList<Telefone>();
		em = null;
		try {
			em = JpaUtils.getEntityManager();
			TelefoneList = em.createQuery("from Telefone", Telefone.class).getResultList();
			return TelefoneList;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public Telefone byId(Long id) {
		Telefone resultado = null;
		em = null;
		try {
			em = JpaUtils.getEntityManager();
			resultado = em.find(Telefone.class, id);
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return null;
	}

	@Override
	public Telefone insert(Telefone entity) {
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
	public Telefone update(Telefone entity) {
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
	public void delete(Telefone entity) {
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
			TelefoneTemp = em.find(Telefone.class, id);
			if (TelefoneTemp != null) {
				em.getTransaction().begin();
				em.remove(TelefoneTemp);
				em.getTransaction().commit();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}
}