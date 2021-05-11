package vietnqv.service;

import java.util.List;

public interface Service<T> {

	public List<T> selectAll();

	public int create(T t);

	public int update(T t);

	public int delete(T t);

	public T find(Integer id);

	public List<T> search(String keyword);

	public List<T> getListPage(Integer page, Integer sum);

}
