package com.crud.test.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crud.test.entities.Commande;
import com.crud.test.entities.Produit;
import com.crud.test.repositories.ProduitRepository;

@Service
public class ProduitServiceImpl extends __CrudService<Produit> {

	@Autowired
	private ProduitRepository produitRepository;
	
	@Override
	public ResponseEntity<Produit> create(Produit produit) {
		// TODO Auto-generated method stub
		try
		{
			Produit produitAdd = this.produitRepository.save(produit);
			
			return new ResponseEntity<>(produitAdd, HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			String message = "Impossible d'enregistrer";
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header(message, message).build();
		}
		
	}

	@Override
	public ResponseEntity<Produit> update(Produit produit, Long id) {
		// TODO Auto-generated method stub
		Optional<Produit> produitFound = this.produitRepository.findById(id);
		
		if(produitFound.isPresent())
		{
			Produit produitToUpdate = produitFound.get();
			
			produitToUpdate.setLibelle(produit.getLibelle());
			produitToUpdate.setPrix(produit.getPrix());
			produitToUpdate.setDevise(produit.getDevise());
			//
			this.produitRepository.save(produitToUpdate);
			
			return new ResponseEntity<>(produitToUpdate,HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<List<Produit>> findAll() {
		// TODO Auto-generated method stub
		 List<Produit> produits = this.produitRepository.findAll();
		  
		  if(!produits.isEmpty())
		  {
			 return new ResponseEntity<>(produits, HttpStatus.OK);
		  } 
		  else 
		  { 
			  return  ResponseEntity.noContent().build(); 
		  } 
	}

	@Override
	public ResponseEntity<Produit> findById(Long id) {
		// TODO Auto-generated method stub
		Optional<Produit> produit = this.produitRepository.findById(id);
		 
		 if(produit.isPresent())
		 {
			 String message = "L'ID du produit est "+ produit.get().getIdproduit();
			
			 return ResponseEntity.status(HttpStatus.OK).header(message, message).body(produit.get());
		 }
		 else 
		 {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		 }
	}

	@Override
	public ResponseEntity<Produit> deleteById(Long id) {
		// TODO Auto-generated method stub
		 Optional<Produit> produit = this.produitRepository.findById(id);
		 
		 if(produit.isPresent())
		 {
			 this.produitRepository.deleteById(id);
			 return new ResponseEntity<>(HttpStatus.OK);

		 }
		 else
		 {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
	}

}
