package com.account.module.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.account.module.controller.RegistrationController;
import com.account.module.dto.LoginDTO;
import com.account.module.dto.RegisterDTO;
import com.account.module.dto.ResetDTO;
import com.account.module.exceptions.RepositoryException;

import lombok.ToString;
@ToString
@Repository
public class RegisterDAOImpl implements RegisterDAO {
	@Autowired
	private SessionFactory sessionFactory;
	static Logger logger = Logger.getLogger(RegisterDAOImpl.class);


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

	/*@Override
	public long fetchEmailCount(RegisterDTO dto) throws RepositoryException {
		Session session = null;
		long emailCount = 0;
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery("select count(*) from RegisterDTO where email=:noe");
			query.setParameter("noe", );
			emailCount = (Long) query.uniqueResult();
			logger.info(emailCount);

		} catch (HibernateException e) {
			throw new RepositoryException(e.getMessage());
		}catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		} finally {
			if (session != null)
				session.close();
		}
		return emailCount;
	}*/
	
	@Override
	public long fetchEmailCount(RegisterDTO dto) throws RepositoryException {
		Session session = null;
		long count=0;
		
		try {
			session = sessionFactory.openSession();	
			Query query = session.createQuery("select count(*) from RegisterDTO where email=:ml");
			query.setParameter("ml",dto.getEmail());
			count=(long) query.uniqueResult();
		logger.debug(count);
		}catch (HibernateException e) {
			throw new RepositoryException(e.getMessage());
		}catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		} finally {
			if (session != null)
				session.close();
		}
		return count;
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
				logger.debug(registerDTO2);
			}
//			logger.info(dto);
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

	@Override
	public String updateNewPassword(RegisterDTO dto) throws RepositoryException {
		Session session = null;
		Transaction transaction = null;
		String tempPassword=null;
		 tempPassword=RandomStringUtils.random(8, true, false);
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("update RegisterDTO set password=:pwd where email=:eml");
			query.setParameter("eml",dto.getEmail());
			query.setParameter("pwd",tempPassword );
			query.executeUpdate();
			transaction.commit();
			logger.info(tempPassword);
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
		
		return tempPassword;
	
	}

	@Override
	public boolean fetchPasswordCountForUpdate(ResetDTO resetDTO) throws RepositoryException{
	Session session = null;
	long count=0;
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery("select count(*) from RegisterDTO  where password=:nop");
			query.setParameter("nop",resetDTO.getTempPassword());
			count=(long) query.uniqueResult();
			if(count>0){
				return true;
			}
		} catch (HibernateException e) {
			throw new RepositoryException(e.getMessage());
		}catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		} finally {
			if (session != null)
				session.close();
		}
		return false;
	}

	@Override
	public String updateNewPassword(ResetDTO resetDTO) throws RepositoryException {
		Session session = null;
		Transaction transaction = null;
		String newPassword = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("update RegisterDTO set password=:npwd where password=:pwd");
			query.setParameter("pwd", resetDTO.getTempPassword());
			query.setParameter("npwd",resetDTO.getNewPassword());
			query.executeUpdate();
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
		
		return newPassword;
	}

	/*@Override
	public RegisterDTO getUserByEmail(String email) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery("select reg from RegisterDTO reg where reg.email=:eml");
			query.setParameter("eml", email);
			return (RegisterDTO) query.uniqueResult();
		}catch(HibernateException e){
		e.printStackTrace();	
		}
		return null;
	}*/
}
