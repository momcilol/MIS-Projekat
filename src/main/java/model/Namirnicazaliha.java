package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the namirnicazaliha database table.
 * 
 */
@Entity
@NamedQuery(name="Namirnicazaliha.findAll", query="SELECT n FROM Namirnicazaliha n")
public class Namirnicazaliha implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(insertable=false, updatable=false)
	private int idnz;

	private double kolicina;

	private String naziv;

	//bi-directional many-to-many association to Dobavljac
	@ManyToMany
	@JoinTable(
		name="dobavlja"
		, joinColumns={
			@JoinColumn(name="idnz")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idd")
			}
		)
	private List<Dobavljac> dobavljacs;

	//bi-directional many-to-one association to Narudzbinanamirnice
	@OneToMany(mappedBy="namirnicazaliha", cascade = CascadeType.MERGE)
	private List<Narudzbinanamirnice> narudzbinanamirnices;

	public Namirnicazaliha() {
		this.dobavljacs = new ArrayList<>();
		this.narudzbinanamirnices = new ArrayList<>();
	}

	public Namirnicazaliha(double kolicina, String naziv) {
		this();
		this.kolicina = kolicina;
		this.naziv = naziv;
	}

	public int getIdnz() {
		return this.idnz;
	}

	public void setIdnz(int idnz) {
		this.idnz = idnz;
	}

	public double getKolicina() {
		return this.kolicina;
	}

	public void setKolicina(double kolicina) {
		this.kolicina = kolicina;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Dobavljac> getDobavljacs() {
		return this.dobavljacs;
	}

	public void setDobavljacs(List<Dobavljac> dobavljacs) {
		this.dobavljacs = dobavljacs;
	}

	public List<Narudzbinanamirnice> getNarudzbinanamirnices() {
		return this.narudzbinanamirnices;
	}

	public void setNarudzbinanamirnices(List<Narudzbinanamirnice> narudzbinanamirnices) {
		this.narudzbinanamirnices = narudzbinanamirnices;
	}

	public Narudzbinanamirnice addNarudzbinanamirnice(Narudzbinanamirnice narudzbinanamirnice) {
		getNarudzbinanamirnices().add(narudzbinanamirnice);
		narudzbinanamirnice.setNamirnicazaliha(this);

		return narudzbinanamirnice;
	}

	public Narudzbinanamirnice removeNarudzbinanamirnice(Narudzbinanamirnice narudzbinanamirnice) {
		getNarudzbinanamirnices().remove(narudzbinanamirnice);
		narudzbinanamirnice.setNamirnicazaliha(null);

		return narudzbinanamirnice;
	}

	@Override
	public String toString() {
		return naziv + kolicina;
	}

}