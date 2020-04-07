package br.com.backend.services;

import java.util.List;

import javax.xml.ws.ServiceMode;

import br.com.backend.dao.impl.PessoaDAOImpl;
import br.com.backend.dao.interfaces.GenericoDAO;
import br.com.backend.entidades.Pessoa;

@ServiceMode
public class PessoaServices {
	
	GenericoDAO<Pessoa, Long> pessoasDAO = new PessoaDAOImpl();
	
	public List<Pessoa> all() {
		return pessoasDAO.all();
	}
	
	public Pessoa byId(Long id) {
		return pessoasDAO.byId(id);
	}
	
	public Pessoa insert(Pessoa entity) {
		return pessoasDAO.insert(entity);
	}
	
	public Pessoa update(Pessoa entity) {
		return pessoasDAO.update(entity);
	}
	
	public void delete(Pessoa entity) {
		pessoasDAO.delete(entity);
	}
	
	public void deleteById(Long id) {
		pessoasDAO.deleteById(id);
	}
}
