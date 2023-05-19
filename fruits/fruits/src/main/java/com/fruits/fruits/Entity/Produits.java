package com.fruits.fruits.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="Produits")
@Data
@ToString
@NoArgsConstructor
public class Produits {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	  
    @Column(name="quantite")
    private int quantite; 
	  
	@Column(name="prixUnitaire")
    private float prixUnitaire; 
	  
	@Column(name="reference")
    private String reference;  
	  
	public Produits(Long id, int quantite, float prixUnitaire, String reference, String designation, String fournisseur,
			String image, String description) {
		super();
		this.id = id;
		this.quantite = quantite;
		this.prixUnitaire = prixUnitaire;
		this.reference = reference;
		this.designation = designation;
		this.fournisseur = fournisseur;
		this.image = image;
		this.description = description;
	}
    
	@Column(name="designation")
    private String designation; 
	  
	@Column(name="fournisseur")
    private String fournisseur;
	  
	@Column(name="image")
    private String image;
	
	@Column(name="description")
    private String description;
	
	public Produits() {
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public float getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(String fournisseur) {
		this.fournisseur = fournisseur;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	} 
	  
}
