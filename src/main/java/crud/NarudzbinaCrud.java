package crud;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Narudzbina;
import model.Onlinemusterija;
import model.Stanje;
import model.Stavkameni;
import utils.PersistenceUtil;

public class NarudzbinaCrud {
	
//	!!!!!!! DON'T FUCKIN' TOUCH THIS !!!!!!!

	public void sacuvajNarudzbinu(boolean placanjeKarticom, Stanje stanje, Onlinemusterija om, List<Stavkameni> s, Date vreme) {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			
			om = em.merge(om);
			s.size();
			Narudzbina n = new Narudzbina(placanjeKarticom, stanje, 0, vreme, om);	
			n.getStavkamenis().addAll(s);	
			
			
			double ukupno = 0;
			for (Stavkameni stavkameni : s) {
				stavkameni = em.merge(stavkameni);
				stavkameni.getNarudzbinas().add(n);
				ukupno += stavkameni.getCena();
			}
			
			n.setUkupno(ukupno);
			om.addNarudzbina(n);
			
			em.persist(n);			
			em.merge(om);

			em.flush();
			et.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(et != null)
				et.rollback();
		}finally {
			if(em != null && em.isOpen())
				em.close();
		}
	}
	
	public Onlinemusterija vratiMusteriju(int id) {
		EntityManager em = PersistenceUtil.getEntityManager();
		Onlinemusterija om = em.find(Onlinemusterija.class, id);
		em.close();
		return om;
	}
	
	public void unesiMusteriju(Onlinemusterija om) {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			
			om = em.merge(om);
			em.persist(om);
			
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
	
	public List<Onlinemusterija> listaOnlinemusterija() {
		EntityManager em = PersistenceUtil.getEntityManager();
		List<Onlinemusterija> lista = em.createQuery("select om from Onlinemusterija om").getResultList();
		em.close();
		return lista;
	}
}
