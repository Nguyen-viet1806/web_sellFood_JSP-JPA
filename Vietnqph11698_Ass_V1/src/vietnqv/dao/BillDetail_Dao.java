package vietnqv.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import vietnqv.server.model.TblBillDetail;
import vietnqv.utils.JPA_Utils;

public class BillDetail_Dao implements Dao<TblBillDetail>{

	@Override
	public List<TblBillDetail> selectAll() {
		List<TblBillDetail> lstBillDetail = new ArrayList<TblBillDetail>();
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			TypedQuery<TblBillDetail> query = em.createNamedQuery("TblBillDetail.findAll", TblBillDetail.class);
			lstBillDetail = query.getResultList();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}finally {
			em.close();
		}
		return lstBillDetail;
	}

	@Override
	public int create(TblBillDetail t) {
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			t.setIdBillDetail(null);
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
	public int update(TblBillDetail t) {
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
	public int delete(TblBillDetail t) {
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
	public TblBillDetail find(Integer id) {
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		TblBillDetail billDetail = new TblBillDetail();
		try {
			trans.begin();
			billDetail = em.find(TblBillDetail.class, id);
			trans.commit();
			return billDetail;
		} catch (Exception e) {
			trans.rollback();
			return null;
		}finally {
			em.close();
		}
	}

	@Override
	public List<TblBillDetail> getListPage(Integer page, Integer sum) {
		List<TblBillDetail> lstBillDetail = new ArrayList<TblBillDetail>();
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			TypedQuery<TblBillDetail> query = em.createNamedQuery("TblBillDetail.findAll", TblBillDetail.class);
			query.setFirstResult(page);
			query.setMaxResults(sum);
			lstBillDetail = query.getResultList();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
		return lstBillDetail;
	}

	@Override
	public List<TblBillDetail> search(String keyword) {
		List<TblBillDetail> lstBillDetail = new ArrayList<TblBillDetail>();
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			TypedQuery<TblBillDetail> query = em.createNamedQuery("TblBillDetail.findAllInBill", TblBillDetail.class);
			int id = Integer.parseInt(keyword);
			query.setParameter("keyword", id);
			lstBillDetail = query.getResultList();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}finally {
			em.close();
		}
		return lstBillDetail;
	}

}
