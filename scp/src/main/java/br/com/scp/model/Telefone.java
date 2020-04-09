package br.com.scp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Telefone implements Serializable {

	public enum TipoTelefone {
		CELULAR, FIXO, COMERCIAL
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	private static final long serialVersionUID = 1L;
	@Version
	@Column(name = "version")
	private int version;

	@Size(max = 3, message = "No máximo {max} números. Você digitou: ${validatedValue}")
	@Pattern(regexp = "\\d{3}", message = "Deve conter somente números")
	@Column(nullable = false)
	private String ddd;

	@Size(min = 8, max = 10, message = "No mínimo {min} e no máximo {max} números. Você digitou: ${validatedValue}")
	@Pattern(regexp = "(?:[0-9]{6}|[0-9]{4})[0-9]{4}", message = "Deve conter somente números")
	@Column(nullable = false)
	private String numero;

	@Column(nullable = false)
	private TipoTelefone tipo;

	@Column(nullable = false)
	private String dataDeCadastro;

	@ManyToOne
	@JoinColumn(name = "login")
	@Column(nullable = false)
	private Operador loginOperador;

	@ManyToOne
	@JoinColumn(name = "id")
	@Column(nullable = false)
	private Pessoa idPessoa;

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
		if (!(obj instanceof Telefone)) {
			return false;
		}
		Telefone other = (Telefone) obj;
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

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public TipoTelefone getTipo() {
		return tipo;
	}

	public void setTipo(TipoTelefone tipo) {
		this.tipo = tipo;
	}

	public String getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(String dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

	public Operador getLoginOperador() {
		return loginOperador;
	}

	public void setLoginOperador(Operador loginOperador) {
		this.loginOperador = loginOperador;
	}

	public Pessoa getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Pessoa idPessoa) {
		this.idPessoa = idPessoa;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (id != null)
			result += "id: " + id;
		result += ", version: " + version;
		if (ddd != null && !ddd.trim().isEmpty())
			result += ", ddd: " + ddd;
		if (numero != null && !numero.trim().isEmpty())
			result += ", numero: " + numero;
		if (tipo != null)
			result += ", tipo: " + tipo;
		if (dataDeCadastro != null && !dataDeCadastro.trim().isEmpty())
			result += ", dataDeCadastro: " + dataDeCadastro;
		if (loginOperador != null)
			result += ", loginOperador: " + loginOperador;
		if (idPessoa != null)
			result += ", idPessoa: " + idPessoa;
		return result;
	}
}