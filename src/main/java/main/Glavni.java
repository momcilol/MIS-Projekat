package main;

import java.util.List;

import crud.MeniCrud;
import crud.NarudzbinaCrud;
import crud.ZalihaCrud;
import model.Dobavljac;
import model.Meni;
import model.Namirnicazaliha;
import model.Stavkameni;

public class Glavni {

	public static void main(String[] args) {
		NarudzbinaCrud nc = new NarudzbinaCrud();
		MeniCrud mc = new MeniCrud();
		ZalihaCrud zc = new ZalihaCrud();
		
//		List<Stavkameni> lista = mc.listaStavki();
//		Onlinemusterija om = nc.vratiMusteriju(1);
//		nc.sacuvajNarudzbinu(false, Stanje.PRIPREMA, om, lista, new Date());
		
//		Meni m = new Meni("Posni meni");
//		mc.dodajNoviMeni(m);
//		Stavkameni s = new Stavkameni(400, "Oslic", true);
//		mc.dodajNovuStavku(s);
//		List<Stavkameni> lista = mc.listaStavki();
//		for (Stavkameni stavkameni : lista) {
//			if (stavkameni.getPosno()) {
//				mc.dodajStavkuUMeni(stavkameni, m);
//			}
//		}
		
//		List<Namirnicazaliha> lista = zc.listaZaliha();
//		for (Namirnicazaliha namirnicazaliha : lista) {
//			System.out.println(namirnicazaliha);
//		}
		
		Namirnicazaliha nz = zc.vratiNamirnicazaliha(5);
		System.out.println(nz);
		List<Dobavljac> list = zc.dobavljaciZaNamirnicu(nz);
		Dobavljac dobavljac = list.get(0);
		zc.sacuvajNarudzbinu(nz, dobavljac, 30);
		
		
		System.exit(0);
	}

}
