package br.com.smarket.util;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BaseDAO <T>{
	
	private Session sessao;
	
	public void insertOrUpdate(T instancia) throws HibernateException{
		sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
        sessao.saveOrUpdate(instancia);
        t.commit();
        sessao.close();
	}
	
	public void delete(Serializable id) throws HibernateException{  
		sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        sessao.delete(sessao.load(type.getActualTypeArguments()[0].getTypeName(), id));
        t.commit();
	}
	
	public List<T> listar()
	{
		sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        return sessao.createCriteria(type.getActualTypeArguments()[0].getTypeName()).list();
	}
}