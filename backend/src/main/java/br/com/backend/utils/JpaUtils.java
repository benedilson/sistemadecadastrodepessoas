package br.com.backend.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {
	
	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = null;
	
	public static EntityManager getEntityManager() {
		if(ENTITY_MANAGER_FACTORY == null) {
			ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("dev-backend");
		}
		
		return ENTITY_MANAGER_FACTORY.createEntityManager();
	}
}
