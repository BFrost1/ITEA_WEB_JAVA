package ua.com.ss.service;

import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import ua.com.ss.DAO.DBWorker;
import ua.com.ss.model.Country;


public class CountryService extends DBWorker<Country> {

	@Override
	public Country get(int id) {
		return entityManager.find(Country.class, id);

	}
	@Override
	public List<Country> get(String column, String param) {
		try {
			return entityManager.createQuery("from Country where " + column + " = :paramName").setParameter("paramName", param).getResultList();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public List<Country> getAll() {
		try {
			return entityManager.createQuery("from Country").getResultList();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void save(Country country) {
		executeInsideTransaction(entityManager -> entityManager.persist(country));
	}

	@Override
	public void update(Country country) {
		executeInsideTransaction(entityManager -> entityManager.merge(country));
	}

	@Override
	public void delete(Country country) {
		executeInsideTransaction(entityManager -> entityManager.remove(country));
	}
	
	private void executeInsideTransaction(Consumer<EntityManager> action) {
		EntityTransaction tx = entityManager.getTransaction();
		try {
			tx.begin();
			action.accept(entityManager);
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		}
	}
}
