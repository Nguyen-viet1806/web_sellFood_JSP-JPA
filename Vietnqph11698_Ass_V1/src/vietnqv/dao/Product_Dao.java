package vietnqv.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import vietnqv.server.model.TblProduct;
import vietnqv.server.model.TblStatus;
import vietnqv.utils.JPA_Utils;

public class Product_Dao implements Dao<TblProduct> {

	Status_Dao dao = new Status_Dao();
	List<TblStatus> lstTblStatus = dao.selectAll();

	@Override
	public List<TblProduct> selectAll() {
		List<TblProduct> lstProduct = new ArrayList<TblProduct>();
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			TypedQuery<TblProduct> query = em.createNamedQuery("TblProduct.findAllWithStatus", TblProduct.class);
			lstProduct = query.getResultList();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
		return lstProduct;
	}

	@Override
	public int create(TblProduct t) {
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			t.setIdProduct(null);
			TblStatus status = new TblStatus();
			for (TblStatus s1 : lstTblStatus) {
				if (s1.getIdStatus() == 1) {
					status = s1;
				}
			}
			t.setTblStatus(status);
			em.persist(t);
			trans.commit();
			return 1;
		} catch (Exception e) {
			trans.rollback();
			return -1;
		} finally {
			em.close();
		}

	}

	@Override
	public int update(TblProduct t) {
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(t);
			trans.commit();
			return 2;
		} catch (Exception e) {
			trans.rollback();
			return -1;
		} finally {
			em.close();
		}
	}

	@Override
	public int delete(TblProduct t) {
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			int result = 0;
			trans.begin();
			if (t.getTblStatus().getIdStatus() == 1) {
				TblStatus status = new TblStatus();
				for (TblStatus s1 : lstTblStatus) {
					if (s1.getIdStatus() == 2) {
						status = s1;
					}
				}

				t.setTblStatus(status);
				em.merge(t);
				result = 3;
			} else {
				TblStatus status = new TblStatus();
				for (TblStatus s1 : lstTblStatus) {
					if (s1.getIdStatus() == 1) {
						status = s1;
					}
				}
				t.setTblStatus(status);
				em.merge(t);
				result = 4;
			}
			trans.commit();
			return result;
		} catch (Exception e) {
			trans.rollback();
			return -1;
		} finally {
			em.close();
		}
	}

	@Override
	public TblProduct find(Integer id) {
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		TblProduct product = new TblProduct();
		try {
			trans.begin();
			product = em.find(TblProduct.class, id);
			trans.commit();
			return product;
		} catch (Exception e) {
			trans.rollback();
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public List<TblProduct> getListPage(Integer page, Integer sum) {
		List<TblProduct> lstProduct = new ArrayList<TblProduct>();
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			TypedQuery<TblProduct> query = em.createNamedQuery("TblProduct.findAllWithStatus", TblProduct.class);
			query.setFirstResult(page);
			query.setMaxResults(sum);
			lstProduct = query.getResultList();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
		return lstProduct;
	}

	@Override
	public List<TblProduct> search(String keyword) {
		List<TblProduct> lstProduct = new ArrayList<TblProduct>();
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			TypedQuery<TblProduct> query = em.createNamedQuery("TblProduct.search", TblProduct.class);
			query.setParameter("keyword", "%"+keyword+"%");
			lstProduct = query.getResultList();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}finally {
			em.close();
		}
		return lstProduct;
	}

}
