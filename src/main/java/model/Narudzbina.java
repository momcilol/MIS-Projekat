package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Enumerated;


/**
 * The persistent class for the narudzbina database table.
 * 
 */
@Entity
@NamedQuery(name="Narudzbina.findAll", query="SELECT n FROM Narudzbina n")
public class Narudzbina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(insertable=false, updatable=false)
	private int idn;

	private boolean placanjeKarticom;

	@Enumerated(value = EnumType.STRING)
	private Stanje stanje;

	private double ukupno;

	@Temporal(TemporalType.TIMESTAMP)
	private Date vreme;

	//bi-directional many-to-one association to Onlinemusterija
	@ManyToOne(cascade={CascadeType.MERGE})
	@JoinColumn(name="idm")
	private Onlinemusterija onlinemusterija;

	//bi-directional many-to-many association to Stavkameni
	@ManyToMany(mappedBy="narudzbinas", cascade={CascadeType.MERGE})
	private List<Stavkameni> stavkamenis;

	public Narudzbina() {
		this.stavkamenis = new ArrayList<>();
	}

	public Narudzbina(boolean placanjeKarticom, Stanje stanje, double ukupno, Date vreme,
			Onlinemusterija onlinemusterija) {
		this();
		this.placanjeKarticom = placanjeKarticom;
		this.stanje = stanje;
		this.ukupno = ukupno;
		this.vreme = vreme;
		this.onlinemusterija = onlinemusterija;
	}

	public int getIdn() {
		return this.idn;
	}

	public void setIdn(int idn) {
		this.idn = idn;
	}

	public boolean getPlacanjeKarticom() {
		return this.placanjeKarticom;
	}

	public void setPlacanjeKarticom(boolean placanjeKarticom) {
		this.placanjeKarticom = placanjeKarticom;
	}

	public Stanje getStanje() {
		return this.stanje;
	}

	public void setStanje(Stanje stanje) {
		this.stanje = stanje;
	}

	public double getUkupno() {
		return this.ukupno;
	}

	public void setUkupno(double ukupno) {
		this.ukupno = ukupno;
	}

	public Date getVreme() {
		return this.vreme;
	}

	public void setVreme(Date vreme) {
		this.vreme = vreme;
	}

	public Onlinemusterija getOnlinemusterija() {
		return this.onlinemusterija;
	}

	public void setOnlinemusterija(Onlinemusterija onlinemusterija) {
		this.onlinemusterija = onlinemusterija;
	}

	public List<Stavkameni> getStavkamenis() {
		return this.stavkamenis;
	}

	public void setStavkamenis(List<Stavkameni> stavkamenis) {
		this.stavkamenis = stavkamenis;
	}

	@Override
	public String toString() {
		return "Narudzbina [" + idn + ", " + placanjeKarticom + ", " + stanje + ", " + ukupno + ", " + vreme + ", "
				+ onlinemusterija + "]";
	}

}