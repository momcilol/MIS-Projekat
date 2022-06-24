package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the narudzbinanamirnice database table.
 * 
 */
@Embeddable
public class NarudzbinanamirnicePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idnz;

	@Column(insertable=false, updatable=false)
	private int idd;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date vreme;

	public NarudzbinanamirnicePK() {
	}
	public int getIdnz() {
		return this.idnz;
	}
	public void setIdnz(int idnz) {
		this.idnz = idnz;
	}
	public int getIdd() {
		return this.idd;
	}
	public void setIdd(int idd) {
		this.idd = idd;
	}
	public java.util.Date getVreme() {
		return this.vreme;
	}
	public void setVreme(java.util.Date vreme) {
		this.vreme = vreme;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof NarudzbinanamirnicePK)) {
			return false;
		}
		NarudzbinanamirnicePK castOther = (NarudzbinanamirnicePK)other;
		return 
			(this.idnz == castOther.idnz)
			&& (this.idd == castOther.idd)
			&& this.vreme.equals(castOther.vreme);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idnz;
		hash = hash * prime + this.idd;
		hash = hash * prime + this.vreme.hashCode();
		
		return hash;
	}
}