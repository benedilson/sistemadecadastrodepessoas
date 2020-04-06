package br.com.backend.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.backend.entidades.Operador;
import br.com.backend.services.interfaces.CrudService;
import br.com.backend.utils.JpaUtils;

public class OperadorService implements CrudService<Operador, Long> {

	@Override
	public List<Operador> all() {
		List<Operador> operadorList = new ArrayList<Operador>();
		EntityManager em = null;
		try {
			em = JpaUtils.getEntityManager();
			operadorList = em.createQuery("from Operador", Operador.class).getResultList();
			return operadorList;
		}
		finally {
			if(em != null) {
				em.close();
			}
		}
	}

	@Override
	public Operador byId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Operador insert(Operador entity) {
		
		EntityManager em = null;
		try {
			em = JpaUtils.getEntityManager();
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			
			return entity;
		} finally {
			if(em != null) {
				em.close();
			}
		}
	}

	@Override
	public Operador update(Operador entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Operador entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
