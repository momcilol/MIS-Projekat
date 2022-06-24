package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sefkuvar database table.
 * 
 */
@Entity
@NamedQuery(name="Sefkuvar.findAll", query="SELECT s FROM Sefkuvar s")
public class Sefkuvar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(insertable=false, updatable=false)
	private int mbs;

	private String adresa;

	private String ime;

	private String password;

	private double plata;

	private String prezime;

	private String telefon;

	public Sefkuvar() {
	}

	public Sefkuvar(String adresa, String ime, String password, double plata, String prezime, String telefon) {
		this();
		this.adresa = adresa;
		this.ime = ime;
		this.password = password;
		this.plata = plata;
		this.prezime = prezime;
		this.telefon = telefon;
	}

	public int getMbs() {
		return this.mbs;
	}

	public void setMbs(int mbs) {
		this.mbs = mbs;
	}

	public String getAdresa() {
		return this.adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getPlata() {
		return this.plata;
	}

	public void setPlata(double plata) {
		this.plata = plata;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getTelefon() {
		return this.telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	@Override
	public String toString() {
		return "Sefkuvar [" + mbs + ", " + adresa + ", " + ime + ", " + password + ", " + plata + ", " + prezime + ", "
				+ telefon + "]";
	}

}