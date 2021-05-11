package vietnqv.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import vietnqv.server.model.TblUser;
import vietnqv.utils.JPA_Utils;

public class User_Dao implements Dao<TblUser>{

	@Override
	public List<TblUser> selectAll() {
		List<TblUser> lstUser = new ArrayList<TblUser>();
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			TypedQuery<TblUser> query = em.createNamedQuery("TblUser.findAll", TblUser.class);
			lstUser = query.getResultList();
			trans.commit();
		}catch (Exception e) {
			trans.rollback();
		}finally {
			em.close();
		}
		return lstUser;
	}

	@Override
	public int create(TblUser t) {
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
	public int update(TblUser t) {
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
	public int delete(TblUser t) {
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
	public TblUser find(Integer id) {
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		TblUser user = new TblUser();
		try {
			trans.begin();
			user = em.find(TblUser.class, id);
			trans.commit();
			return user;
		} catch (Exception e) {
			trans.rollback();
			return null;
		}finally {
			em.close();
		}
	}

	@Override
	public List<TblUser> getListPage(Integer page, Integer sum) {
		List<TblUser> lstUser = new ArrayList<TblUser>();
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			TypedQuery<TblUser> query = em.createNamedQuery("TblUser.findAll", TblUser.class);
			query.setFirstResult(page);
			query.setMaxResults(sum);
			lstUser = query.getResultList();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
		return lstUser;
	}

	@Override
	public List<TblUser> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
