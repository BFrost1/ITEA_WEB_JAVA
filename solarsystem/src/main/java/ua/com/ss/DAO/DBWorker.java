package ua.com.ss.DAO;

import javax.persistence.EntityManager;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public abstract class DBWorker<T> implements DBWorkerDAO<T> {
	
	public static EntityManager entityManager = new AnnotationConfigApplicationContext("ua.com.ss.configurations").getBean("entityManager", EntityManager.class);
	
}
