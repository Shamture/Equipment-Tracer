package com.dataTransfer;

import com.beans.Materiel;

public class MaterielRep implements Comparable<MaterielRep> {

	private int id;

	private String description;

	private String designation;
	private String categorie;
	private String etat;
	private double longitude;
	private double latitude;

	private int delai;

	private int joursRestantDansLeDelai;

	public MaterielRep() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public int getDelai() {
		return delai;
	}

	public void setDelai(int delai) {
		this.delai = delai;
	}

	public int getJoursRestantDansLeDelai() {
		return joursRestantDansLeDelai;
	}

	public void setJoursRestantDansLeDelai(int joursRestantDansLeDelai) {
		this.joursRestantDansLeDelai = joursRestantDansLeDelai;
	}

	public static MaterielRep generateMateriel(Materiel materiel, String categorie) {
		MaterielRep mat = new MaterielRep();
		mat.setDelai(materiel.getDelai());
		mat.setDescription(materiel.getDescription());
		mat.setDesignation(materiel.getDesignation());
		mat.setId(materiel.getId());
		mat.setLatitude(materiel.getLatitude());
		mat.setLongitude(materiel.getLongitude());

		if (materiel.getEtat() == 1)
			mat.setEtat("actif");
		else
			mat.setEtat("non actif");
		mat.setCategorie(categorie);
		return mat;

	}

	public static MaterielRep generateMateriel(Materiel materiel, String categorie, int joursRestant) {
		MaterielRep mat = new MaterielRep();
		mat.setDelai(materiel.getDelai());
		mat.setDescription(materiel.getDescription());
		mat.setDesignation(materiel.getDesignation());
		mat.setId(materiel.getId());
		mat.setLatitude(materiel.getLatitude());
		mat.setLongitude(materiel.getLongitude());

		if (materiel.getEtat() == 1)
			mat.setEtat("actif");
		else
			mat.setEtat("non actif");
		mat.setCategorie(categorie);
		mat.setJoursRestantDansLeDelai(mat.getDelai() - joursRestant);
		return mat;

	}

	public int compareTo(MaterielRep o) {
		if (o.getJoursRestantDansLeDelai() == this.joursRestantDansLeDelai)
			return 1;
		return (this.joursRestantDansLeDelai > o.getJoursRestantDansLeDelai()) ? 10 : -10;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categorie == null) ? 0 : categorie.hashCode());
		result = prime * result + delai;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((designation == null) ? 0 : designation.hashCode());
		result = prime * result + ((etat == null) ? 0 : etat.hashCode());
		result = prime * result + id;
		result = prime * result + joursRestantDansLeDelai;
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MaterielRep other = (MaterielRep) obj;
		if (categorie == null) {
			if (other.categorie != null)
				return false;
		} else if (!categorie.equals(other.categorie))
			return false;
		if (delai != other.delai)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (designation == null) {
			if (other.designation != null)
				return false;
		} else if (!designation.equals(other.designation))
			return false;
		if (etat == null) {
			if (other.etat != null)
				return false;
		} else if (!etat.equals(other.etat))
			return false;
		if (id != other.id)
			return false;
		if (joursRestantDansLeDelai != other.joursRestantDansLeDelai)
			return false;
		if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MaterielRep [id=" + id + ", description=" + description + ", designation=" + designation
				+ ", categorie=" + categorie + ", etat=" + etat + ", longitude=" + longitude + ", latitude=" + latitude
				+ ", delai=" + delai + ", joursRestantDansLeDelai=" + joursRestantDansLeDelai + "]";
	}

}
