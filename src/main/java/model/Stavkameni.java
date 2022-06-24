package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the stavkameni database table.
 * 
 */
@Entity
@NamedQuery(name="Stavkameni.findAll", query="SELECT s FROM Stavkameni s")
public class Stavkameni implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(insertable=false, updatable=false)
	private int ids;

	private double cena;

	private String naziv;

	private boolean posno;

	//bi-directional many-to-many association to Narudzbina
	@ManyToMany(cascade={CascadeType.MERGE})
	@JoinTable(
		name="stavkeunarudzbini"
		, joinColumns={
			@JoinColumn(name="ids")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idn")
			}
		)
	private List<Narudzbina> narudzbinas;

	public Stavkameni() {
		this.narudzbinas = new ArrayList<>();
	}

	public Stavkameni(double cena, String naziv, boolean posno) {
		this();
		this.cena = cena;
		this.naziv = naziv;
		this.posno = posno;
	}

	public int getIds() {
		return this.ids;
	}

	public void setIds(int ids) {
		this.ids = ids;
	}

	public double getCena() {
		return this.cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public boolean getPosno() {
		return this.posno;
	}

	public void setPosno(boolean posno) {
		this.posno = posno;
	}

	public List<Narudzbina> getNarudzbinas() {
		return this.narudzbinas;
	}

	public void setNarudzbinas(List<Narudzbina> narudzbinas) {
		this.narudzbinas = narudzbinas;
	}

	@Override
	public String toString() {
		String daLiJePosno = posno ? "Posno" : "Nije posno";
		return naziv + ", " + daLiJePosno + ", cena: " + cena;
	}

}