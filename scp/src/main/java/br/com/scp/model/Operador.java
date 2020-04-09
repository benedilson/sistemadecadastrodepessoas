package br.com.scp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Operador implements Serializable {

	public enum Perfil {
		GERENTE, ANALISTA, ADMINISTRADOR
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	private static final long serialVersionUID = 1L;
	@Version
	@Column(name = "version")
	private int version;

	@Size(max = 100, message = "No máximo {max} caracteres. Você digitou: ${validatedValue}")
	@Pattern(regexp = "[A-Za-z]*", message = "Não deve conter números")
	@Column(nullable = false)
	private String nome;

	@Size(max = 15, message = "No máximo {max} caracteres. Você digitou: ${validatedValue}")
	@Pattern(regexp = "[A-Za-z\\-\\_]*", message = "Deve conter somente letras, - ou _")
	@Column(nullable = false)
	private String login;

	@Size(min = 6, max = 15, message = "No mínimo {min} e no máximo {max} caracteres. Você digitou: ${validatedValue}")
	@Pattern(regexp = "[^\\s]*", message = "Não deve conter espaços em branco")
	@Column(nullable = false)
	private String senha;

	@Column(nullable = false)
	private Perfil perfil;

	@Column(nullable = false)
	private String dataDeCadastro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Operador)) {
			return false;
		}
		Operador other = (Operador) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public String getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(String dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (id != null)
			result += "id: " + id;
		result += ", version: " + version;
		if (nome != null && !nome.trim().isEmpty())
			result += ", nome: " + nome;
		if (login != null && !login.trim().isEmpty())
			result += ", login: " + login;
		if (senha != null && !senha.trim().isEmpty())
			result += ", senha: " + senha;
		if (perfil != null)
			result += ", perfil: " + perfil;
		if (dataDeCadastro != null && !dataDeCadastro.trim().isEmpty())
			result += ", dataDeCadastro: " + dataDeCadastro;
		return result;
	}
}