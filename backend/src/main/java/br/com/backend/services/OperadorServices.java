package br.com.backend.services;

import java.util.List;

import javax.xml.ws.ServiceMode;

import br.com.backend.dao.impl.OperadorDAOImpl;
import br.com.backend.dao.interfaces.GenericoDAO;
import br.com.backend.entidades.Operador;

@ServiceMode
public class OperadorServices {
	
	GenericoDAO<Operador, Long> operadorDAO = new OperadorDAOImpl();
	
	public List<Operador> all() {
		return operadorDAO.all();
	}
	
	public Operador byId(Long id) {
		return operadorDAO.byId(id);
	}
	
	public Operador insert(Operador entity) {
		return operadorDAO.insert(entity);
	}
	
	public Operador update(Operador entity) {
		return operadorDAO.update(entity);
	}
	
	public void delete(Operador entity) {
		operadorDAO.delete(entity);
	}
	
	public void deleteById(Long id) {
		operadorDAO.deleteById(id);
	}
}
