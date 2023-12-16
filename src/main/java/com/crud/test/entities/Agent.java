package com.crud.test.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="agent")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Agent implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;
	
	 
	private String matricule;
	
	
	private String nom;
	
	private String PostNom;
	
	
	private String photo;
	
	private String prenom;
	
	
	private String sexe;
	

}
