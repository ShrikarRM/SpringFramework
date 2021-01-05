package com.account.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.account.dto.PatientDTO;

import lombok.Setter;
//@Setter
//@Repository
public class PatientDAOImpl implements PatientDAO {
	//@Autowired
	private SessionFactory factory;

	public PatientDAOImpl(SessionFactory factory) {
		System.out.println(this.getClass().getSimpleName() + " created");
		this.factory = factory;
	}

	public long save(PatientDTO patientDTO) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.save(patientDTO);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
		} finally {
			if (session != null)
				session.close();
			if (factory != null)
				factory.close();
		}
		System.out.println("invoked save in PatientDAOImpl");

		return 0;
	}

}
