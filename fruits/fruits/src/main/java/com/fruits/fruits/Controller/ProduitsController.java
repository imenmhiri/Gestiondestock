package com.fruits.fruits.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fruits.fruits.Entity.Produits;
import com.fruits.fruits.Entity.User;
import com.fruits.fruits.Model.ApiResponse;
import com.fruits.fruits.Model.CreateProduitsRequest;
import com.fruits.fruits.Model.RequestSignup;
import com.fruits.fruits.Model.UpdateRequest;
import com.fruits.fruits.Service.ProduitsService;

import jakarta.validation.constraints.NotNull;

@RestController 
@CrossOrigin(origins = "*")
@RequestMapping(path = "/Produits")
public class ProduitsController {
	@Autowired
	private ProduitsService produits; 
	
	//Pour creer un nouveau produit 
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<?> saveProduits(@Valid @RequestBody CreateProduitsRequest createProduitsRequest) {
		Produits produit=produits.findByReference(createProduitsRequest.getReference()); 
 	    if (produit!=null) {
 		   return ResponseEntity
	                  .badRequest()
	                  .body("Produit existant!");
 	   }
 	   // sinon creer le nouveau produit 
	  produits.saveProduits(createProduitsRequest);
      return ResponseEntity.ok(new ApiResponse(true, " ok"));
	     
	}
	@RequestMapping(value = "/afficher", method = RequestMethod.GET)
	    public @NotNull Iterable<Produits> getProducts(Long id) {
	        return produits.getProduct();
	    }
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<?> saveProduits(@Valid @RequestBody UpdateRequest UpdateProductRequest) {
		Produits produit=produits.findByReference(UpdateProductRequest.getReference()); 
 	    if (produit==null) {
 		   return ResponseEntity
	                  .badRequest()
	                  .body("Produit inexistant!");
 	   }
 	  // sinon mise a jour le nouveau produit 
	  produits.updateProduits(UpdateProductRequest);
      return ResponseEntity.ok(new ApiResponse(true, " ok"));
	     
	}
	
}
