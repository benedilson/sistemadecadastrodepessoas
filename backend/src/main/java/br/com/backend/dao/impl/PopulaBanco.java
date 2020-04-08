package br.com.backend.dao.impl;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import br.com.backend.entidades.Operador;
import br.com.backend.utils.JpaUtils;
import br.com.backend.utils.MetodosUteis;

public class PopulaBanco {
	public static void main(String[] args) {
		EntityManager em = new JpaUtils().getEntityManager();
		Operador operador = new Operador();
		
		operador.setNomeOperador("Antonio");
		operador.setLoginOperador("a");
		operador.setSenhaOperador("a");
		operador.setPerfilOperador(Operador.Perfil.ADMINISTRADOR);
		operador.setDataDeCadastroOperador(MetodosUteis.AjustaLocalDate(LocalDate.now()));
		
		
		em.getTransaction().begin();
		em.persist(operador);
		em.getTransaction().commit();
		em.close();
	}
}
