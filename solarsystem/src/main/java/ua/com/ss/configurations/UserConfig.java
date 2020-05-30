package ua.com.ss.configurations;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ua.com.ss.DAO.DBWorkerDAO;
import ua.com.ss.model.Country;
import ua.com.ss.model.User;
import ua.com.ss.service.CountryService;
import ua.com.ss.service.ItemService;
import ua.com.ss.service.UserService;


@Configuration
public class UserConfig {
	
	@Bean
	public Country country() {
		return new Country();
	}
	
	@Bean
	public User user() {
		return new User();
	}
	
	@Bean
	public EntityManager entityManager() {
		return Persistence.createEntityManagerFactory("User").createEntityManager();
	}
	
	@Bean
	public DBWorkerDAO<?> userService() {
		return new UserService(); 
	}
	
	@Bean
	public DBWorkerDAO<?> countryService() {
		return new CountryService();
	}
}
