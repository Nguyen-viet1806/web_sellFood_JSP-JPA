package vietnqv.dao;

import java.util.List;

public interface Dao<T> {
	
public  List<T> selectAll();
	
public int create(T t) ;
	
public int update(T t) ;

public int delete(T t) ;

public T find(Integer id);

public List<T> search(String keyword);

public List<T> getListPage(Integer page,Integer sum);

	
}
