package ua.com.ss.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ua.com.ss.DAO.DBWorkerDAO;
import ua.com.ss.service.ItemService;

@Configuration
public class ItemConfig {
	
	@Bean
	public DBWorkerDAO<?> itemService() {
		return new ItemService();
	}
}
