package vietnqv.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import vietnqv.server.model.TblCategory;
import vietnqv.server.model.TblStatus;
import vietnqv.utils.JPA_Utils;

public class Category_Dao implements Dao<TblCategory> {

	Status_Dao dao = new Status_Dao();
	List<TblStatus> lstTblStatus = dao.selectAll();

	@Override
	public List<TblCategory> selectAll() {
		List<TblCategory> lstCategory = new ArrayList<TblCategory>();
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			TypedQuery<TblCategory> query = em.createNamedQuery("TblCategory.findAll", TblCategory.class);
			lstCategory = query.getResultList();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}finally {
			em.close();
		}
		return lstCategory;
	}

	@Override
	public int create(TblCategory t) {
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			t.setIdCategory(null);
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
		}finally {
			em.close();
		}
	}

	@Override
	public int update(TblCategory t) {
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
	public int delete(TblCategory t) {
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
				result =3;
			}else {
				TblStatus status = new TblStatus();
				for (TblStatus s1 : lstTblStatus) {
					if (s1.getIdStatus() == 1) {
						status = s1;
					}
				}
				t.setTblStatus(status);
				em.merge(t);
				result =4;
			}
			trans.commit();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			return -1;
		}finally {
			em.close();
		}
	}

	@Override
	public TblCategory find(Integer id) {
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		TblCategory category = new TblCategory();
		try {
			trans.begin();
			category = em.find(TblCategory.class, id);
			trans.commit();
			return category;
		} catch (Exception e) {
			trans.rollback();
			return null;
		}finally {
			em.close();
		}
	}

	@Override
	public List<TblCategory> getListPage(Integer page, Integer sum) {
		List<TblCategory> lstCategory = new ArrayList<TblCategory>();
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			TypedQuery<TblCategory> query = em.createNamedQuery("TblCategory.findAll", TblCategory.class);
			query.setFirstResult(page);
			query.setMaxResults(sum);
			lstCategory = query.getResultList();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
		return lstCategory;
	}

	@Override
	public List<TblCategory> search(String keyword) {
		List<TblCategory> lstCategory = new ArrayList<TblCategory>();
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			TypedQuery<TblCategory> query = em.createNamedQuery("TblCategory.search", TblCategory.class);
			query.setParameter("keyword", "%"+keyword+"%");
			lstCategory = query.getResultList();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}finally {
			em.close();
		}
		return lstCategory;
	}

}
