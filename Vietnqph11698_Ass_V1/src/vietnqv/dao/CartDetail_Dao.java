package vietnqv.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import vietnqv.server.model.TblCartDetail;
import vietnqv.server.model.TblStatus;
import vietnqv.utils.JPA_Utils;

public class CartDetail_Dao implements Dao<TblCartDetail> {

	Status_Dao dao = new Status_Dao();
	List<TblStatus> lstTblStatus = dao.selectAll();

	@Override
	public List<TblCartDetail> selectAll() {
		List<TblCartDetail> lstCartDetail = new ArrayList<TblCartDetail>();
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			TypedQuery<TblCartDetail> query = em.createNamedQuery("TblCartDetail.findAll", TblCartDetail.class);
			lstCartDetail = query.getResultList();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
		return lstCartDetail;
	}

	@Override
	public int create(TblCartDetail t) {
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			t.setIdCartDetail(null);
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
	public int update(TblCartDetail t) {
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
	public int delete(TblCartDetail t) {
	
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		int chon = 0;
		try {
			trans.begin();
			StoredProcedureQuery query = em.createNamedStoredProcedureQuery("TblCartDetail.delete");
			query.setParameter("Id", t.getIdCartDetail());
			 query.execute();
			trans.commit();
			return chon;
			
		} catch (Exception e) {
			trans.rollback();
			return chon;
		} finally {
			em.close();
		}
		
	}

	@Override
	public TblCartDetail find(Integer id) {
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		TblCartDetail cartDetail = new TblCartDetail();
		try {
			trans.begin();
			cartDetail = em.find(TblCartDetail.class, id);
			trans.commit();
			return cartDetail;
		} catch (Exception e) {
			trans.rollback();
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public List<TblCartDetail> getListPage(Integer page, Integer sum) {
		List<TblCartDetail> lstCartDetail = new ArrayList<TblCartDetail>();
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			TypedQuery<TblCartDetail> query = em.createNamedQuery("TblCartDetail.findAll", TblCartDetail.class);
			query.setFirstResult(page);
			query.setMaxResults(sum);
			lstCartDetail = query.getResultList();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
		return lstCartDetail;
	}

	@Override
	public List<TblCartDetail> search(String keyword) {
		List<TblCartDetail> lstCartDetail = new ArrayList<TblCartDetail>();
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			TypedQuery<TblCartDetail> query = em.createNamedQuery("TblCartDetail.search", TblCartDetail.class);
			int id = Integer.parseInt(keyword);
			query.setParameter("keyword", id);
			lstCartDetail = query.getResultList();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
		return lstCartDetail;
	}

}
