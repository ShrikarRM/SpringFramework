package com.account.module.dao;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.account.module.dto.RegisterDTO;

@Repository
public class RegisterDAOImpl implements RegisterDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public long save(RegisterDTO dto) {
		Session session = null;
		Transaction transaction = null;
		Serializable serializable=null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			serializable=session.save(dto);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null)
				session.close();
		}
		return (long)serializable;
	}
}
