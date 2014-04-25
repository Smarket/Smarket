package br.com.smarket.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Secao {

	@Id
	@GeneratedValue
	private long id;
	private String nome;
	@Column(nullable = false)
	private int xInicial;
	@Column(nullable = false)
	private int xFinal;
	@Column(nullable = false)
	private int yInicial;
	@Column(nullable = false)
	private int yFinal;
	@OneToMany(targetEntity = Produto.class, mappedBy = "secao", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<Produto> produtos;

	public Secao() {
		this.setId(0);
		this.setNome("");
		this.setxFinal(0);
		this.setxInicial(0);
		this.setyFinal(0);
		this.setyInicial(0);
		this.setProdutos(new ArrayList<Produto>());
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

	public int getxInicial() {
		return xInicial;
	}

	public void setxInicial(int xInicial) {
		this.xInicial = xInicial;
	}

	public int getxFinal() {
		return xFinal;
	}

	public void setxFinal(int xFinal) {
		this.xFinal = xFinal;
	}

	public int getyInicial() {
		return yInicial;
	}

	public void setyInicial(int yInicial) {
		this.yInicial = yInicial;
	}

	public int getyFinal() {
		return yFinal;
	}

	public void setyFinal(int yFinal) {
		this.yFinal = yFinal;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}
