package br.com.backend.services;

import java.util.List;

import javax.xml.ws.ServiceMode;

import br.com.backend.dao.impl.TelefoneDAOImpl;
import br.com.backend.dao.interfaces.GenericoDAO;
import br.com.backend.entidades.Telefone;

@ServiceMode
public class TelefoneServices {
	
	GenericoDAO<Telefone, Long> telefoneDAO = new TelefoneDAOImpl();
	
	public List<Telefone> all() {
		return telefoneDAO.all();
	}
	
	public Telefone byId(Long id) {
		return telefoneDAO.byId(id);
	}
	
	public Telefone insert(Telefone entity) {
		return telefoneDAO.insert(entity);
	}
	
	public Telefone update(Telefone entity) {
		return telefoneDAO.update(entity);
	}
	
	public void delete(Telefone entity) {
		telefoneDAO.delete(entity);
	}
	
	public void deleteById(Long id) {
		telefoneDAO.deleteById(id);
	}
}
