package ua.com.ss.service;

import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


import ua.com.ss.DAO.DBWorker;
import ua.com.ss.model.User;

public class UserService extends DBWorker<User>{

	@Override
	public User get(int id) {
		return entityManager.find(User.class, id);
	}
	
	@Override
	public List<User> get(String column, String param) {
		try {
			return entityManager.createQuery("from User where " + column + " = :paramName").setParameter("paramName", param).getResultList();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<User> getAll() {
		try {
			return entityManager.createQuery("from User").getResultList();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void save(User user) {
		 executeInsideTransaction(entityManager -> entityManager.persist(user));
	}

	@Override
	public void update(User user) {
		executeInsideTransaction(entityManager -> entityManager.merge(user));
	}

	@Override
	public void delete(User user) {
		executeInsideTransaction(entityManager -> entityManager.remove(user));
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
