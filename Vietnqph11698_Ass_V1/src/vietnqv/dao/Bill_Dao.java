package vietnqv.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import vietnqv.server.model.TblBill;
import vietnqv.server.model.TblBillDetail;
import vietnqv.server.model.TblStatus;
import vietnqv.utils.JPA_Utils;

public class Bill_Dao implements Dao<TblBill> {
	Status_Dao dao = new Status_Dao();
	List<TblStatus> lstTblStatus = dao.selectAll();

	@Override
	public List<TblBill> selectAll() {
		List<TblBill> lstBill = new ArrayList<TblBill>();
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			TypedQuery<TblBill> query = em.createNamedQuery("TblBill.findAll", TblBill.class);
			lstBill = query.getResultList();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
		return lstBill;
	}

	@Override
	public int create(TblBill t) {
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			t.setIdBill(null);
			TblStatus status = new TblStatus();
			for (TblStatus s1 : lstTblStatus) {
				if (s1.getIdStatus() == 3) {
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
	public int update(TblBill t) {
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			TblBill bill = em.find(TblBill.class, t.getIdBill());
			bill.setTblStatus(em.find(TblStatus.class, t.getTblStatus().getIdStatus()));
			em.merge(bill);
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
	public int delete(TblBill t) {
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
		} finally {
			em.close();
		}
	}

	@Override
	public TblBill find(Integer id) {
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		TblBill bill = new TblBill();
		try {
			trans.begin();
			bill = em.find(TblBill.class, id);
			trans.commit();
			return bill;
		} catch (Exception e) {
			trans.rollback();
			return null;
		} finally {
			em.close();
		}

	}

	@Override
	public List<TblBill> getListPage(Integer page, Integer sum) {
		List<TblBill> lstBill = new ArrayList<TblBill>();
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			TypedQuery<TblBill> query = em.createNamedQuery("TblBill.findAll", TblBill.class);
			query.setFirstResult(page);
			query.setMaxResults(sum);
			lstBill = query.getResultList();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
		return lstBill;
	}

	@Override
	public List<TblBill> search(String keyword) {
		List<TblBill> lstBill = new ArrayList<TblBill>();
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			TypedQuery<TblBill> query = em.createNamedQuery("TblBill.findAllInUser", TblBill.class);
			int id = Integer.parseInt(keyword);
			query.setParameter("keyword", id);
			lstBill = query.getResultList();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
		return lstBill;
	}

}
