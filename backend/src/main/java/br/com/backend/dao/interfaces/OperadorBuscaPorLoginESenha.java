package br.com.backend.dao.interfaces;

import javax.ejb.Local;

import br.com.backend.entidades.Operador;

@Local
public interface OperadorBuscaPorLoginESenha extends GenericoDAO<Operador, Long> {
	Operador pesquisaPorLoginESenha(String login, String senha);
}
