package br.com.smarket.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {
	
	@Id
	private String login;
	private String senha;
	private boolean administrador; 
	
	public Usuario() {
		this.setLogin("");
		this.setSenha("");
		this.setAdministrador(false);
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

	public boolean getAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean isAdministrador) {
		this.administrador = isAdministrador;
	}
}
