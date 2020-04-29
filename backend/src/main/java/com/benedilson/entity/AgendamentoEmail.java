package com.benedilson.entity;

public class AgendamentoEmail {
	@Id
	private Long id;
	private String email;
	private Boolean enviado;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Boolean getEnviado() {
		return enviado;
	}
	
	public void setEnviado(Boolean enviado) {
		this.enviado = enviado;
	}
	
	
}
