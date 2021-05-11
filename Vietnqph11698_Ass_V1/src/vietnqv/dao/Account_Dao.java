package vietnqv.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import vietnqv.server.model.TblAccount;
import vietnqv.utils.JPA_Utils;

public class Account_Dao implements Dao<TblAccount> {

	@Override
	public List<TblAccount> selectAll() {
		List<TblAccount> lstAccounts = new ArrayList<TblAccount>();
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			TypedQuery<TblAccount> query = em.createNamedQuery("TblAccount.findAll", TblAccount.class);
			lstAccounts = query.getResultList();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}finally {
			em.close();
		}
		return lstAccounts;
	}

	@Override
	public int create(TblAccount t) {
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
	public int update(TblAccount t) {

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
	public int delete(TblAccount t) {
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
	public TblAccount find(Integer id) {
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		TblAccount account = new TblAccount();
		try {
			trans.begin();
			account = em.find(TblAccount.class, id);
			trans.commit();
			return account;
		} catch (Exception e) {
			trans.rollback();
			return null;
		}finally {
			em.close();
		}
		
	}

	@Override
	public List<TblAccount> getListPage(Integer page, Integer sum) {
		List<TblAccount> lstAccounts = new ArrayList<TblAccount>();
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			TypedQuery<TblAccount> query = em.createNamedQuery("TblAccount.findAll", TblAccount.class);
			query.setFirstResult(page);
			query.setMaxResults(sum);
			lstAccounts = query.getResultList();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}finally {
			em.close();
		}
		return lstAccounts;
	}

	@Override
	public List<TblAccount> search(String keyword) {
		List<TblAccount> lstAccounts = new ArrayList<TblAccount>();
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			TypedQuery<TblAccount> query = em.createNamedQuery("TblAccount.search", TblAccount.class);
			query.setParameter("keyword", keyword);
			lstAccounts = query.getResultList();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}finally {
			em.close();
		}
		return lstAccounts;
	}

}
