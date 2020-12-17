package com.account.loosecoupling.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.account.loosecoupling.dto.ElectionResultsDTO;

import lombok.Setter;

@Setter
public class ElectionresultsDAOImpl implements ElectionResultsDAO {
	private SessionFactory factory = null;

	public ElectionresultsDAOImpl() {
		System.out.println("created " + this.getClass().getSimpleName());
	}

	public ElectionresultsDAOImpl(SessionFactory factory) {
		super();
		this.factory = factory;
	}

	@Override
	public String validateAndSave(ElectionResultsDTO dto) {
		Session session = null;
		Transaction transaction = null;
		try {

			session = factory.openSession();
			transaction = session.beginTransaction();
			session.save(dto);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return null;
	}

	@Override
	public String deleteById(long resultId) {
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			ElectionResultsDTO dto = session.get(ElectionResultsDTO.class, resultId);
			if (dto != null) {
				dto.setResultId(resultId);
				session.delete(dto);
			}
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		return null;
	}

	@Override
	public void updateWardNoById(int wardNo, long resultId) {
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			ElectionResultsDTO dto = session.get(ElectionResultsDTO.class, resultId);
			if (dto != null) {
				dto.setWardNo(wardNo);
				dto.setResultId(resultId);
				session.close();
			}
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

	}

	@Override
	public ElectionResultsDTO getByPartyName(String partyName) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			ElectionResultsDTO dto = session.get(ElectionResultsDTO.class, partyName);
			System.out.println(dto);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		return null;
	}

	@Override
	public List<ElectionResultsDTO> getList() {
		Session session = null;
		List<ElectionResultsDTO> resultdto = null;
		try {
			session = factory.openSession();
			Query query = session.createQuery("from ElectionResultsDTO dto");
			resultdto = (List<ElectionResultsDTO>) query.list();
			for (ElectionResultsDTO dto1 : resultdto) {
				System.out.println(dto1);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		return resultdto;
	}

}
