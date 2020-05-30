package ua.com.ss.service;

import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import ua.com.ss.DAO.DBWorker;
import ua.com.ss.model.Item;


public class ItemService extends DBWorker<Item> {

	@Override
	public Item get(int id) {
		return entityManager.find(Item.class, id);
	}

	@Override
	public List<Item> get(String column, String param) {
		try {
			return entityManager.createQuery("from Item where " + column + " = :paramName").setParameter("paramName", param).getResultList();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Item> getAll() {
		try {
			return entityManager.createQuery("from Item").getResultList();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void save(Item item) {
		 executeInsideTransaction(entityManager -> entityManager.persist(item));
		
	}

	@Override
	public void update(Item item) {
		executeInsideTransaction(entityManager -> entityManager.merge(item));
		
	}

	@Override
	public void delete(Item item) {
		executeInsideTransaction(entityManager -> entityManager.remove(item));
		
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
