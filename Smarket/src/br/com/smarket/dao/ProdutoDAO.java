package br.com.smarket.dao;

import java.util.List;

import org.hibernate.Criteria;

import br.com.smarket.model.Produto;
import br.com.smarket.util.HibernateUtil;

public class ProdutoDAO extends BaseDAO<Produto>{

	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> listar() {
		this.setSessao(HibernateUtil.getSessionFactory().openSession());
		Criteria criteria = this.getSessao().createCriteria(Produto.class);
		List<Produto> lista =  criteria.list();
		return lista;
	}

}
