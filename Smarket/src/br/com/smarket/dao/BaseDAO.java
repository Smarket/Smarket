package br.com.smarket.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.smarket.util.HibernateUtil;

public abstract class BaseDAO <T>{
	
	private Session sessao;
	
	public Session getSessao() {
		return sessao;
	}

	public void setSessao(Session sessao) {
		this.sessao = sessao;
	}

	public void insertOrUpdate(T instancia){
		this.sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
        try{
        	this.sessao.saveOrUpdate(instancia);
        	t.commit();
        } catch (HibernateException e){
        	e.printStackTrace();
        	if(!t.wasCommitted()){
        		t.rollback();
        	}
        } finally{
        	 this.sessao.close();
        }
	}
	
	public void delete(T instancia) {  
		this.sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = this.sessao.beginTransaction();
		sessao.delete(instancia);
		t.commit();
	}
	
	public abstract List<T> listar();
	
}