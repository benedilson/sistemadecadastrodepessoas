package br.com.backend.tests;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.backend.entidades.Operador;
import br.com.backend.services.impl.OperadorService;
import br.com.backend.services.interfaces.CrudService;
import br.com.backend.utils.MetodosUteis;

public class OperadorTest {

	@Test
	public void verificandoInsertOperador() {
		Operador o = new Operador();
		o.setNomeOperador("Benedilson");
		o.setLoginOperador("administrador");
		o.setSenhaOperador("administrador");
		o.setPerfilOperador(Operador.Perfil.ADMINISTRADOR);
		o.setDataDeCadastroOperador(MetodosUteis.AjustaLocalDate(LocalDate.now()));
		
		try {
			CrudService<Operador, Long> operadorService = new OperadorService();
			operadorService.insert(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void verificandoListagemDeTodosOsOperarios() {
		try {
			CrudService<Operador, Long> operadorService = new OperadorService();
			List<Operador> operadores = new ArrayList<Operador>();
			operadores = operadorService.all();
			
			operadores.forEach(operador -> {
				System.out.println(String.format("Id = " + operador.getIdOperador() + (" Nome do Operador = ") + operador.getNomeOperador()));
			});
			
			Assert.assertNotNull(operadores);

		} catch (Exception e) {
			System.out.println("Entro no catch");
			System.out.println(e.getMessage());
		}
	}
	
}
