package com.account.integration.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.account.integration.DTO.CoronaVaccineDTO;

import lombok.Setter;
@Setter
public class CoronaVaccineDAO {
	/*public CoronaVaccineDAO() {
		System.out.println(this.getClass().getSimpleName() + " created");
	}*/

	private SessionFactory sessionFactory;

	private Session session;

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
}
