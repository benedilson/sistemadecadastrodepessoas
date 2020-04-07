package br.com.backend.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import br.com.backend.dao.interfaces.GenericoDAO;
import br.com.backend.entidades.Pessoa;
import br.com.backend.utils.JpaUtils;

@Stateless
public class PessoaDAOImpl implements GenericoDAO<Pessoa, Long> {

	private EntityManager em;
	private List<Pessoa> PessoaList = null;
	private Pessoa PessoaTemp = null;

	@Override
	public List<Pessoa> all() {
		PessoaList = new ArrayList<Pessoa>();
		em = null;
		try {
			em = JpaUtils.getEntityManager();
			PessoaList = em.createQuery("from Pessoa", Pessoa.class).getResultList();
			return PessoaList;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public Pessoa byId(Long id) {
		Pessoa resultado = null;
		em = null;
		try {
			em = JpaUtils.getEntityManager();
			resultado = em.find(Pessoa.class, id);
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return null;
	}

	@Override
	public Pessoa insert(Pessoa entity) {
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
	public Pessoa update(Pessoa entity) {
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
	public void delete(Pessoa entity) {
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
			PessoaTemp = em.find(Pessoa.class, id);
			if (PessoaTemp != null) {
				em.getTransaction().begin();
				em.remove(PessoaTemp);
				em.getTransaction().commit();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}
}