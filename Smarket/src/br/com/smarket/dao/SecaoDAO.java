package br.com.smarket.dao;

import java.util.List;

import org.hibernate.Criteria;

import br.com.smarket.model.Secao;
import br.com.smarket.util.HibernateUtil;

public class SecaoDAO extends BaseDAO<Secao>{

	@SuppressWarnings("unchecked")
	@Override
	public List<Secao> listar() {
		this.setSessao(HibernateUtil.getSessionFactory().openSession());
		Criteria criteria = this.getSessao().createCriteria(Secao.class);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Secao> lista =  criteria.list();
		this.getSessao().clear();
		return lista;
	}

}
