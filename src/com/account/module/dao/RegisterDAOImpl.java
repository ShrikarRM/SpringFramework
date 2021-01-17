package com.account.module.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.account.module.dto.LoginDTO;
import com.account.module.dto.RegisterDTO;
import com.account.module.exceptions.RepositoryException;

import lombok.ToString;
@ToString
@Repository
public class RegisterDAOImpl implements RegisterDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(RegisterDTO dto) throws RepositoryException {
		Session session = null;
		Transaction transaction = null;
		Serializable serializable = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			serializable = session.save(dto);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
				throw new RepositoryException(e.getMessage());
			}
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			throw new RepositoryException(e.getMessage());
		} finally {
			if (session != null)
				session.close();
		}
		return (long) serializable;
	}

	@Override
	public long fetchEmailCount(String email) throws RepositoryException {
		Session session = null;
		long emailCount = 0;
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery("select count(*) from RegisterDTO where email=:noe");
			query.setParameter("noe", email);
			emailCount = (Long) query.uniqueResult();
			System.out.println(emailCount);

		} catch (HibernateException e) {
			throw new RepositoryException(e.getMessage());
		}catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		} finally {
			if (session != null)
				session.close();
		}
		return emailCount;
	}
	
	@Override
	public List<RegisterDTO> fetchDetailsforLogin(RegisterDTO dto) throws RepositoryException {
		Session session = null;
		List<RegisterDTO> registerDTO=null;
		
		try {
			session = sessionFactory.openSession();
			
			Query query = session.createQuery("select reg from RegisterDTO reg where reg.email=:ml");
			query.setParameter("ml",dto.getEmail());
			registerDTO=(List<RegisterDTO>) query.list();
			for (RegisterDTO registerDTO2 : registerDTO) {
				System.out.println(registerDTO2);
			}
//			System.out.println(dto);
		}catch (HibernateException e) {
			throw new RepositoryException(e.getMessage());
		}catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		} finally {
			if (session != null)
				session.close();
		}
		return registerDTO;
	}
}
