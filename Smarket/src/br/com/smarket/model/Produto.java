package br.com.smarket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Produto {
		
    @Id
    @GeneratedValue
	private long id;
    @Column(nullable=false)
	private String nome;
    @Column(nullable=false)
	private double peso;
	@Column(nullable=false)
	private boolean baixaTemperatura;
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
	
	@Override
	public String toString() {
		return this.getNome();
	}
	
	@Override
	public boolean equals(Object produto) {
		return this.getId()==(((Produto)produto).getId());
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
