package br.com.smarket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import com.sun.istack.internal.NotNull;

@Entity
public class Produto {
		
    @Id
    @NotNull
    @GeneratedValue
	private long id;
    @NotNull
	private String nome;
	private double peso;
	@NotNull
	private boolean baixaTemperatura;
	@NotNull
	@ManyToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_ProdutoSecao"), nullable=false)
	private Secao secao;
	
	public Produto() {
		this.setId(0);
		this.setNome("");
		this.setPeso(0);
		this.setBaixaTemperatura(false);
		this.setSecao(null);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public boolean getBaixaTemperatura() {
		return baixaTemperatura;
	}

	public void setBaixaTemperatura(boolean baixaTemperatura) {
		this.baixaTemperatura = baixaTemperatura;
	}

	public Secao getSecao() {
		return secao;
	}

	public void setSecao(Secao secao) {
		this.secao = secao;
	}
}
