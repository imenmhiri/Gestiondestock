package com.fruits.fruits.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fruits.fruits.Exception.RessourcesNotFoundException;
import com.fruits.fruits.Entity.Produits;
import com.fruits.fruits.Entity.User;
import com.fruits.fruits.Model.CreateProduitsRequest;
import com.fruits.fruits.Model.UpdateRequest;
import com.fruits.fruits.Repository.ProduitsRepository;

@Service
public class ProduitsService {
	@Autowired
	private ProduitsRepository ProduitsDao;
	
	
	private static List<Produits> defaultItems() {
		    return List.of(
		     new Produits(1L,15, 140.0, "1", "banane", "","",""),
		     new Produits(2L,11, 100.0, "2", "kiwi", "","",""),
		     new Produits(3L,6, 10.0, "3", "citron", "","",""), 
		     new Produits(4L,15, 75.0, "4", "melon", "","",""),
		     new Produits(5L,15, 135.0, "5", "pomme", "","",""),
		     new Produits(6L,15, 30.0, "6", "orange", "","",""),
		     new Produits(7L,15, 175.0, "7", "mango", "","",""),
		     new Produits(8L,15, 11.0, "8", "fraise", "","",""),
		     new Produits(9L,15, 170.0, "9", "framboise ", "","",""),
		     new Produits(10L,15, 50.0, "10", "mûre", "","","")); 


	 }
    //Pour creer un nouveau produit 
	public Produits saveProduits(CreateProduitsRequest createProduitsRequest) {
		Produits newProduit = new Produits();
		newProduit.setQuantite(createProduitsRequest.getQuantite());
		newProduit.setPrixUnitaire((createProduitsRequest.getPrixUnitaire()));
		newProduit.setReference(createProduitsRequest.getReference());
		newProduit.setDesignation(createProduitsRequest.getDesignation());
		newProduit.setFournisseur(createProduitsRequest.getFournisseur());
		newProduit.setDescription(createProduitsRequest.getDescription());
		newProduit.setImage(createProduitsRequest.getImage());
		return ProduitsDao.save(newProduit);
	}
	public  Produits findByReference(String Reference) {
	       return ProduitsDao.findByReference(Reference);        
	}
    // Pour mettre à jour un produit existant 
    public Produits updateProduits(UpdateRequest UpdateProductRequest) {
        if (ProduitsDao.existsById(UpdateProductRequest.getId())){
        	Produits existingProduits = ProduitsDao.findById(UpdateProductRequest.getId()).get();
        	existingProduits.setQuantite(UpdateProductRequest.getQuantite());
        	existingProduits.setPrixUnitaire(UpdateProductRequest.getPrixUnitaire());
        	existingProduits.setReference(UpdateProductRequest.getReference());
        	existingProduits.setDesignation(UpdateProductRequest.getDesignation());
        	existingProduits.setFournisseur(UpdateProductRequest.getFournisseur());
        	existingProduits.setImage(UpdateProductRequest.getImage());
        	Produits UpdatedProduits = ProduitsDao.save(existingProduits);
        	return(UpdatedProduits); 
        }else{
            return null;
        }
    } 
    //Pour afficher tous les produits 
    public Produits getProduct(long id) {
        return ProduitsDao
                .findById(id)
                .orElseThrow(() -> new RessourcesNotFoundException("Product not found"));
    }


}
