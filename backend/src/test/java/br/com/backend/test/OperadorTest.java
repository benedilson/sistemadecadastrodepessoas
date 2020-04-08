package br.com.backend.test;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.backend.dao.interfaces.GenericoDAORemote;
import br.com.backend.entidades.Operador;
import br.com.backend.utils.MetodosUteis;

public class OperadorTest {

	private GenericoDAORemote<Operador, Long> operadorPR;

	@Before
	public void setUp() throws Exception {
		Context context = null;
		operadorPR = null;
		try {
			context = JNDILookupClass.getInitialContext();
			operadorPR = (GenericoDAORemote<Operador, Long>) context
					.lookup("ejb:backendEAR/backendEJB/PessoaDAOImpl!br.com.backend.dao.interfaces.GenericoDAORemote");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Operador operador = new Operador();
		operador.setNomeOperador("Teste");
		operador.setLoginOperador("t");
		operador.setSenhaOperador("t");
		operador.setPerfilOperador(Operador.Perfil.ANALISTA);
		operador.setDataDeCadastroOperador(MetodosUteis.AjustaLocalDate(LocalDate.now()));

		operador = operadorPR.insert(operador);
		assertNotNull(operador.getIdOperador());
	}

}
