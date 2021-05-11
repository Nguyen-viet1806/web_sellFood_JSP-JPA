package vietnqv.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import vietnqv.server.model.TblCart;
import vietnqv.utils.JPA_Utils;

public class Cart_Dao implements Dao<TblCart>{

	@Override
	public List<TblCart> selectAll() {
		List<TblCart> lstCart = new ArrayList<TblCart>();
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			TypedQuery<TblCart> query = em.createNamedQuery("TblCart.findAll", TblCart.class);
			lstCart = query.getResultList();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}finally {
			em.close();
		}
		return lstCart;
	}

	@Override
	public int create(TblCart t) {
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(t);
			trans.commit();
			return 1;
		} catch (Exception e) {
			trans.rollback();
			return -1;
		}finally {
			em.close();
		}
	}

	@Override
	public int update(TblCart t) {
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
		}finally {
			em.close();
		}
	}

	@Override
	public int delete(TblCart t) {
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.remove(t);
			trans.commit();
			return 3;
		} catch (Exception e) {
			trans.rollback();
			return -1;
		}finally {
			em.close();
		}
	}

	@Override
	public TblCart find(Integer id) {
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		TblCart cart = new TblCart();
		try {
			trans.begin();
			cart = em.find(TblCart.class, id);
			trans.commit();
			return cart;
		} catch (Exception e) {
			trans.rollback();
			return null;
		}finally {
			em.close();
		}
	}

	@Override
	public List<TblCart> getListPage(Integer page, Integer sum) {
		List<TblCart> lstCart = new ArrayList<TblCart>();
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			TypedQuery<TblCart> query = em.createNamedQuery("TblCart.findAll", TblCart.class);
			query.setFirstResult(page);
			query.setMaxResults(sum);
			lstCart = query.getResultList();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
		return lstCart;
	}

	@Override
	public List<TblCart> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
