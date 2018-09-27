package com.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Operation")
public class Operation {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nom;
	private String description;
	private String date_operation;
	private int idMateriel;
	
	public Operation(){
		
	}

	public Operation(int id, String nom, String description, String date_operation, int idMateriel) {
		
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.date_operation = date_operation;
		this.idMateriel = idMateriel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate_operation() {
		return date_operation;
	}

	public void setDate_operation(String date_operation) {
		this.date_operation = date_operation;
	}

	public int getIdMateriel() {
		return idMateriel;
	}

	public void setIdMateriel(int idMateriel) {
		this.idMateriel = idMateriel;
	}
	
	
}
