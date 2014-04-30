package br.com.smarket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {
	
	@Id
	private String login;
	@Column(nullable=false)
	private String senha;
	private boolean administrador; 
	private boolean autenticado; 
	
	public Usuario() {
		this.setAdministrador(false);
	}
	
	@Override
	public String toString() {
		return this.getLogin();
	}
	
	@Override
	public boolean equals(Object usuario) {
		return this.getLogin().equals(((Usuario) usuario).getLogin());
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
	
	public boolean getAutenticado(){
		return autenticado;
	}
	
	public void autenticar(String senha){
		this.setSenha(senha);
		this.autenticado = true;
		
	}
	
}
