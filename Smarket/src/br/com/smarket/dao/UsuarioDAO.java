package br.com.smarket.dao;

import java.util.List;

import org.hibernate.Criteria;

import br.com.smarket.model.Usuario;
import br.com.smarket.util.HibernateUtil;

public class UsuarioDAO extends BaseDAO<Usuario>{

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listar() {
		this.setSessao(HibernateUtil.getSessionFactory().openSession());
		Criteria criteria = this.getSessao().createCriteria(Usuario.class);
		List<Usuario> lista =  criteria.list();
		return lista;
	}

	
}
