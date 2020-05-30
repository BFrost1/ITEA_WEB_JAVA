package ua.com.ss.DAO;

import java.util.List;



public interface DBWorkerDAO <T> {
	
	T get(int id);
	
	List<T> get(String column, String param);
	
    List<T> getAll();
     
    void save(T t);
     
    void update(T t);
     
    void delete(T t);
}
