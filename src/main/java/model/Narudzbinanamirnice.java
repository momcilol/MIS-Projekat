package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the narudzbinanamirnice database table.
 * 
 */
@Entity
@NamedQuery(name="Narudzbinanamirnice.findAll", query="SELECT n FROM Narudzbinanamirnice n")
public class Narudzbinanamirnice implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private NarudzbinanamirnicePK id;

	private double kolicina;

	//bi-directional many-to-one association to Dobavljac
	@ManyToOne
	@JoinColumn(name = "idd", insertable = false, updatable = false)
	@MapsId("idd")
	private Dobavljac dobavljac;

	//bi-directional many-to-one association to Namirnicazaliha
	@ManyToOne
	@JoinColumn(name="idnz", insertable = false, updatable = false)
	@MapsId("idnz")
	private Namirnicazaliha namirnicazaliha;

	public Narudzbinanamirnice() {
	}

	public NarudzbinanamirnicePK getId() {
		return this.id;
	}

	public void setId(NarudzbinanamirnicePK id) {
		this.id = id;
	}

	public double getKolicina() {
		return this.kolicina;
	}

	public void setKolicina(double kolicina) {
		this.kolicina = kolicina;
	}

	public Dobavljac getDobavljac() {
		return this.dobavljac;
	}

	public void setDobavljac(Dobavljac dobavljac) {
		this.dobavljac = dobavljac;
	}

	public Namirnicazaliha getNamirnicazaliha() {
		return this.namirnicazaliha;
	}

	public void setNamirnicazaliha(Namirnicazaliha namirnicazaliha) {
		this.namirnicazaliha = namirnicazaliha;
	}

	@Override
	public String toString() {
		return "Narudzbinanamirnice [" + kolicina + ", " + dobavljac + ", " + namirnicazaliha + "]";
	}

}