package vietnqv.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import vietnqv.server.model.TblRole;
import vietnqv.utils.JPA_Utils;

public class Role_Dao implements Dao<TblRole>{

	@Override
	public List<TblRole> selectAll() {
		List<TblRole> lstRole = new ArrayList<TblRole>();
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			TypedQuery<TblRole> query = em.createNamedQuery("TblRole.findAll", TblRole.class);
			lstRole = query.getResultList();
			trans.commit();
		}catch (Exception e) {
			trans.rollback();
		}finally {
			em.close();
		}
		return lstRole;
	}

	@Override
	public int create(TblRole t) {
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
	public int update(TblRole t) {
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
	public int delete(TblRole t) {
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
	public TblRole find(Integer id) {
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		TblRole role = new TblRole();
		try {
			trans.begin();
			role = em.find(TblRole.class, id);
			trans.commit();
			return role;
		} catch (Exception e) {
			trans.rollback();
			return null;
		}finally {
			em.close();
		}
	}

	@Override
	public List<TblRole> getListPage(Integer page, Integer sum) {
		List<TblRole> lstRole = new ArrayList<TblRole>();
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			TypedQuery<TblRole> query = em.createNamedQuery("TblRole.findAll", TblRole.class);
			query.setFirstResult(page);
			query.setMaxResults(sum);
			lstRole = query.getResultList();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
		return lstRole;
	}

	@Override
	public List<TblRole> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
