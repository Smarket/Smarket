package br.com.smarket.util;

import org.hibernate.*;

public class BaseDAO <T>{
	
	public void insertOrUpdate(T instancia) throws Exception{  
		Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
        sessao.saveOrUpdate(instancia);
        t.commit();
       // sessao.getSessionFactory().close();
	}
}