package vietnqv.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import vietnqv.server.model.TblStatus;
import vietnqv.utils.JPA_Utils;

public class Status_Dao implements Dao<TblStatus>{

	@Override
	public List<TblStatus> selectAll() {
		List<TblStatus> lstStatus = new ArrayList<TblStatus>();
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			TypedQuery<TblStatus> query = em.createNamedQuery("TblStatus.findAll", TblStatus.class);
			lstStatus = query.getResultList();
			trans.commit();
		}catch (Exception e) {
			trans.rollback();
		}finally {
			em.close();
		}
		return lstStatus;
	}

	@Override
	public int create(TblStatus t) {
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
	public int update(TblStatus t) {
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
	public int delete(TblStatus t) {
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
	public TblStatus find(Integer id) {
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		TblStatus status = new TblStatus();
		try {
			trans.begin();
			status = em.find(TblStatus.class, id);
			trans.commit();
			return status;
		} catch (Exception e) {
			trans.rollback();
			return null;
		}finally {
			em.close();
		}
	}

	@Override
	public List<TblStatus> getListPage(Integer page, Integer sum) {
		List<TblStatus> lstStatus = new ArrayList<TblStatus>();
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			TypedQuery<TblStatus> query = em.createNamedQuery("TblStatus.findAll", TblStatus.class);
			query.setFirstResult(page);
			query.setMaxResults(sum);
			lstStatus = query.getResultList();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
		return lstStatus;
	}

	@Override
	public List<TblStatus> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
