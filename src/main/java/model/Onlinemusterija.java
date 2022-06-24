package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the onlinemusterija database table.
 * 
 */
@Entity
@NamedQuery(name="Onlinemusterija.findAll", query="SELECT o FROM Onlinemusterija o")
public class Onlinemusterija implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(insertable=false, updatable=false)
	private int idm;

	private String adresa;

	private String brKartice;

	private String email;

	private String ime;

	private String password;

	private String prezime;

	private String telefon;

	//bi-directional many-to-one association to Narudzbina
	@OneToMany(mappedBy="onlinemusterija", cascade={CascadeType.ALL})
	private List<Narudzbina> narudzbinas;

	public Onlinemusterija() {
		this.narudzbinas = new ArrayList<>();
	}

	public Onlinemusterija(String adresa, String brKartice, String email, String ime, String password, String prezime,
			String telefon) {
		this();
		this.adresa = adresa;
		this.brKartice = brKartice;
		this.email = email;
		this.ime = ime;
		this.password = password;
		this.prezime = prezime;
		this.telefon = telefon;
	}

	public int getIdm() {
		return this.idm;
	}

	public void setIdm(int idm) {
		this.idm = idm;
	}

	public String getAdresa() {
		return this.adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getBrKartice() {
		return this.brKartice;
	}

	public void setBrKartice(String brKartice) {
		this.brKartice = brKartice;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public List<Narudzbina> getNarudzbinas() {
		return this.narudzbinas;
	}

	public void setNarudzbinas(List<Narudzbina> narudzbinas) {
		this.narudzbinas = narudzbinas;
	}

	public Narudzbina addNarudzbina(Narudzbina narudzbina) {
		getNarudzbinas().add(narudzbina);
		narudzbina.setOnlinemusterija(this);

		return narudzbina;
	}

	public Narudzbina removeNarudzbina(Narudzbina narudzbina) {
		getNarudzbinas().remove(narudzbina);
		narudzbina.setOnlinemusterija(null);

		return narudzbina;
	}

	@Override
	public String toString() {
		return "Onlinemusterija [" + idm + ", " + adresa + ", " + brKartice + ", " + email + ", " + ime + ", "
				+ password + ", " + prezime + ", " + telefon + "]";
	}

}