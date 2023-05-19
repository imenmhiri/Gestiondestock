package com.fruits.fruits.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fruits.fruits.Entity.Produits;
@Repository
public interface ProduitsRepository extends JpaRepository<Produits, Long> {
	Produits  findByReference(String reference);
	boolean existsById(Long id); 
}
