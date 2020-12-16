package com.account.integration.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.account.integration.dto.CoronaVaccineDTO;

import lombok.Setter;
import lombok.ToString;

@Setter

public class CoronaVaccineDAO {
private String userId;
private SessionFactory sessionFactory=null;

	public CoronaVaccineDAO() {
		System.out.println(this.getClass().getSimpleName() + " created");
	}

	public CoronaVaccineDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	public void save(CoronaVaccineDTO dto) {
		Session session = null;
		Transaction transaction = null;
		try {
			/*
			 * Configuration configuration=new Configuration();
			 * configuration.configure("resources/hibernate.cfg.xml");
			 * sessionFactory=configuration.buildSessionFactory();
			 */
			session = sessionFactory.openSession();
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
	}
	
	
	public void readDataById(long vaccineId) {
		Session session = null;
		Transaction transaction=null;
		try {
			session = sessionFactory.openSession();
			transaction=session.beginTransaction();
			CoronaVaccineDTO dto = session.get(CoronaVaccineDTO.class, vaccineId);
			System.out.println(dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateNameById(String name, long vaccineId){
		Session session=null;

	
		try{
			session=sessionFactory.openSession();
			session.beginTransaction();
			CoronaVaccineDTO dto=session.get(CoronaVaccineDTO.class, vaccineId);
			if (dto != null) {
				dto.setCountry("India");
				dto.setName(name);
				dto.setVaccineId(vaccineId);
				session.update(dto);
			}
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void deleteById(long vaccineId){
		Session session=null;

		try{
			session=sessionFactory.openSession();
			session.beginTransaction();
			CoronaVaccineDTO dto=session.get(CoronaVaccineDTO.class, vaccineId);
			if (dto != null) {
				dto.setVaccineId(vaccineId);
				session.delete(dto);
			}
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
}
