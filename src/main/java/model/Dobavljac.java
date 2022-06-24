package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the dobavljac database table.
 * 
 */
@Entity
@NamedQuery(name="Dobavljac.findAll", query="SELECT d FROM Dobavljac d")
public class Dobavljac implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(insertable=false, updatable=false)
	private int idd;

	private String naziv;

	//bi-directional many-to-many association to Namirnicazaliha
	@ManyToMany(mappedBy="dobavljacs")
	private List<Namirnicazaliha> namirnicazalihas;

	//bi-directional many-to-one association to Narudzbinanamirnice
	@OneToMany(mappedBy="dobavljac")
	private List<Narudzbinanamirnice> narudzbinanamirnices;

	public Dobavljac() {
		this.namirnicazalihas = new ArrayList<>();
		this.narudzbinanamirnices = new ArrayList<>();
	}

	public Dobavljac(String naziv) {
		this();
		this.naziv = naziv;
	}

	public int getIdd() {
		return this.idd;
	}

	public void setIdd(int idd) {
		this.idd = idd;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Namirnicazaliha> getNamirnicazalihas() {
		return this.namirnicazalihas;
	}

	public void setNamirnicazalihas(List<Namirnicazaliha> namirnicazalihas) {
		this.namirnicazalihas = namirnicazalihas;
	}

	public List<Narudzbinanamirnice> getNarudzbinanamirnices() {
		return this.narudzbinanamirnices;
	}

	public void setNarudzbinanamirnices(List<Narudzbinanamirnice> narudzbinanamirnices) {
		this.narudzbinanamirnices = narudzbinanamirnices;
	}

	public Narudzbinanamirnice addNarudzbinanamirnice(Narudzbinanamirnice narudzbinanamirnice) {
		getNarudzbinanamirnices().add(narudzbinanamirnice);
		narudzbinanamirnice.setDobavljac(this);

		return narudzbinanamirnice;
	}

	public Narudzbinanamirnice removeNarudzbinanamirnice(Narudzbinanamirnice narudzbinanamirnice) {
		getNarudzbinanamirnices().remove(narudzbinanamirnice);
		narudzbinanamirnice.setDobavljac(null);

		return narudzbinanamirnice;
	}

	@Override
	public String toString() {
		return naziv;
	}

}