package br.com.backend.tests;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

import br.com.backend.dao.impl.OperadorDAOImpl;
import br.com.backend.dao.interfaces.GenericoDAO;
import br.com.backend.dao.interfaces.OperadorBuscaPorLoginESenha;
import br.com.backend.entidades.Operador;
import br.com.backend.utils.MetodosUteis;

public class OperadorTest {

	private static Scanner SCANNER = null;
	private GenericoDAO<Operador, Long> operadorService = null;
	private Operador operador = null, operadorTemp = null;
	private List<Operador> operadores = null;

	@Test
	public void pesquisaPorLoginESenha() {

		OperadorBuscaPorLoginESenha server = new OperadorDAOImpl();
		Operador o = null;
		try {
			o = server.pesquisaPorLoginESenha("administrador", "administrador");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Assert.assertNotNull(o);
		if (o != null) {
			System.out.println("Id = " + o.getIdOperador());
			System.out.println("Data de cadastro = " + o.getDataDeCadastroOperador());
			System.out.println("Login = " + o.getLoginOperador());
			System.out.println("Nome = " + o.getNomeOperador());
			System.out.println("Perfil = " + o.getPerfilOperador());
			System.out.println("Senha = " + o.getSenhaOperador());
		}
	}

	@Test
	public void verificandoInsertOperador() {
//		operador = new Operador();
//		operador.setNomeOperador("Antonio");
//		operador.setLoginOperador("g");
//		operador.setSenhaOperador("g");
//		operador.setPerfilOperador(Operador.Perfil.GERENTE);
//		operador.setDataDeCadastroOperador(MetodosUteis.AjustaLocalDate(LocalDate.now()));
//
//		try {
//			operadorService = new OperadorDAOImpl();
//			operadorTemp = operadorService.insert(operador);
//
//			Assert.assertNotNull(operadorTemp);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	@Test
	public void verificandoListagemDeTodosOsOperarios() {
//		try {
//			operadorService = new OperadorDAOImpl();
//			operadores = new ArrayList<Operador>();
//			operadores = operadorService.all();
//
//			operadores.forEach(operador -> {
//				System.out.println(String.format(
//						"Id = " + operador.getIdOperador() + (" Nome do Operador = ") + operador.getNomeOperador()));
//			});
//
//			Assert.assertNotNull(operadores);
//
//		} catch (Exception e) {
//			System.out.println("Entro no catch");
//			System.out.println(e.getMessage());
//		}
	}

	@Test
	public void verificandoAtualizacao() {
//		System.out.println("Testando atulizar");
//
//		operador = new Operador();
//
//		System.out.println("Digite o id do operador a ser atualizado: ");
//
//		//Long idOpe = SCANNER.nextLong();
//
//		SCANNER.nextInt(); // para ler o enter
//
//		//Assert.assertNotNull(idOpe);
//
//		//operadorTemp = operadorService.byId(idOpe);
//
//		Assert.assertNotNull(operadorTemp);
//
//		System.out.println("Pessoa encontrada");
//
//		operador.setNomeOperador("administrador");
//
//		operadorTemp = operadorService.update(operador);
//
//		Assert.assertNotNull(operadorTemp);
//		System.out.println("Nome alterado para: " + operadorTemp.getNomeOperador());
//
//		SCANNER.close();
	}

	@Test
	public void verificandoDeletar() {
//		System.out.println("Testando deletar");
//
//		operador = new Operador();
//
//		System.out.println("Digite o id do operador a ser removido do banco: ");
//
//		//Long idOpe = SCANNER.nextLong();
//
//		//SCANNER.nextInt(); // para ler o enter
//
//		//Assert.assertNotNull(idOpe);
//
//		//operadorTemp = operadorService.byId(idOpe);
//
//		Assert.assertNotNull(operadorTemp);
//
//		System.out.println("Pessoa encontrada");
//
//		//operadorService.deleteById(idOpe);
//
//		System.out.println("Operador removido com sucesso!");
//
//		//SCANNER.close();
	}
}
