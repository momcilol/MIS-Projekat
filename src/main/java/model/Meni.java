package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the meni database table.
 * 
 */
@Entity
@NamedQuery(name="Meni.findAll", query="SELECT m FROM Meni m")
public class Meni implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(insertable=false, updatable=false)
	private int idmn;

	private String naziv;

	//uni-directional many-to-many association to Stavkameni
	@ManyToMany
	@JoinTable(
		name="stavkeumeniju"
		, joinColumns={
			@JoinColumn(name="idmn")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ids")
			}
		)
	private List<Stavkameni> stavkamenis;

	public Meni() {
		this.stavkamenis = new ArrayList<>();
	}

	public Meni(String naziv) {
		this();
		this.naziv = naziv;
	}

	public int getIdmn() {
		return this.idmn;
	}

	public void setIdmn(int idmn) {
		this.idmn = idmn;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Stavkameni> getStavkamenis() {
		return this.stavkamenis;
	}

	public void setStavkamenis(List<Stavkameni> stavkamenis) {
		this.stavkamenis = stavkamenis;
	}

	@Override
	public String toString() {
		return naziv;
	}

}