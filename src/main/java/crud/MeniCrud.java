package crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Menadzer;
import model.Meni;
import model.Sefkuvar;
import model.Stavkameni;
import utils.PersistenceUtil;

public class MeniCrud {

	public List<Stavkameni> prikaziMeni(Meni m){
		EntityManager em = PersistenceUtil.getEntityManager();
		m = em.merge(m);
		m.getStavkamenis().size();
		List<Stavkameni> lista = m.getStavkamenis();
		em.close();
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Stavkameni> listaStavki() {
		EntityManager em = PersistenceUtil.getEntityManager();
		List<Stavkameni> lista = em.createQuery("select s from Stavkameni s").getResultList();
		em.close();
		return lista;
	}
	
	public void dodajNovuStavku(Stavkameni s) {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			
			s = em.merge(s);
			em.persist(s);
			
			em.flush();
			et.commit();
		}catch (Exception e) {
			e.printStackTrace();
			if(et != null)
				et.rollback();
		}finally {
			if(em != null)
				em.close();
		}
	}
	
	public void dodajNoviMeni(Meni m) {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			
			em.persist(m);
			
			em.flush();
			et.commit();
		}catch (Exception e) {
			e.printStackTrace();
			if(et != null)
				et.rollback();
		}finally {
			if(em != null)
				em.close();
		}
	}
	
	public boolean dodajStavkuUMeni(Stavkameni s, Meni m) {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			
			m = em.merge(m);
			s = em.merge(s);
			
			if (!m.getStavkamenis().contains(s)) {
				m.getStavkamenis().add(s);
			} else {
				return false;
			}
			
			em.merge(m);
			
			em.flush();
			et.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			if(et != null)
				et.rollback();
		}finally {
			if(em != null)
				em.close();
		}
		return false;
	}
	
	public List<Menadzer> listaMenadzera() {
		EntityManager em = PersistenceUtil.getEntityManager();
		List<Menadzer> lista = em.createQuery("select m from Menadzer m").getResultList();
		em.close();
		return lista;
	}
	
	public List<Sefkuvar> listaSefkuvara() {
		EntityManager em = PersistenceUtil.getEntityManager();
		List<Sefkuvar> lista = em.createQuery("select s from Sefkuvar s").getResultList();
		em.close();
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Meni> listaMenija() {
		EntityManager em = PersistenceUtil.getEntityManager();
		List<Meni> lista = em.createQuery("select m from Meni m").getResultList();
		em.close();
		return lista;
	}
	
}
