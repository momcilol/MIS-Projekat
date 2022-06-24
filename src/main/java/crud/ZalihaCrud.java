package crud;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Dobavljac;
import model.Namirnicazaliha;
import model.Narudzbinanamirnice;
import model.NarudzbinanamirnicePK;
import utils.PersistenceUtil;

public class ZalihaCrud {

	@SuppressWarnings("unchecked")
	public List<Namirnicazaliha> listaZaliha() {
		EntityManager em = PersistenceUtil.getEntityManager();
		List<Namirnicazaliha> lista = em.createQuery("select n from Namirnicazaliha n").getResultList();
		em.close();
		return lista;
	}
	
	public List<Dobavljac> dobavljaciZaNamirnicu(Namirnicazaliha n) {
		EntityManager em = PersistenceUtil.getEntityManager();
		n = em.merge(n);
		n.getDobavljacs().size();
		List<Dobavljac> lista = n.getDobavljacs();
		em.close();
		return lista;		
	}
	
	public Namirnicazaliha vratiNamirnicazaliha(int id) {
		EntityManager em = PersistenceUtil.getEntityManager();
		Namirnicazaliha nz = em.find(Namirnicazaliha.class, id);
		em.close();
		return nz;
	}
	
	public void sacuvajNarudzbinu(Namirnicazaliha nz, Dobavljac d, double kolicina) {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			
			d = em.merge(d);
			nz = em.merge(nz);
			
			NarudzbinanamirnicePK nnpk = new NarudzbinanamirnicePK();
			nnpk.setIdd(d.getIdd());
			nnpk.setIdnz(nz.getIdnz());
			nnpk.setVreme(new Date());
			
			Narudzbinanamirnice nn = new Narudzbinanamirnice();
			nn.setId(nnpk);
			nn.setKolicina(kolicina);
			nn.setDobavljac(d);
			nn.setNamirnicazaliha(nz);
			
			em.persist(nn);
			
			d.getNarudzbinanamirnices().add(nn);
			nz.getNarudzbinanamirnices().add(nn);
			nz.setKolicina(nz.getKolicina() + kolicina);
			
			em.merge(d);
			em.merge(nz);
			em.flush();
			et.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(et != null)
				et.rollback();
		} finally {
			if(em != null && em.isOpen())
				em.close();
		}
	}
	
	
}
