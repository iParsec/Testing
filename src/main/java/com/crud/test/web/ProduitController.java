package com.crud.test.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.test.entities.Client;
import com.crud.test.entities.Produit;
import com.crud.test.repositories.ClientRespository;
import com.crud.test.repositories.ProduitRepository;
import com.crud.test.services.ProduitServiceImpl;

@RequestMapping(value="/crud")
@RestController
@CrossOrigin(value="*")


/*
 *  API ROUTES
 *   
 * /crud/produit.index : Pour lister tous les clients 
 * /crud/produit.show/{id} : Pour lister un client suivant son ID 
 * /crud/produit.update/{id} : Pour modifier un client suivant son ID 
 * /crud/produit.create : Pour ajouter un nouveau
 * cllient /crud/produit.destroy/{id} : Pour supprimer un client suivant son ID
 */
public class ProduitController {
	
	@Autowired
	private ProduitServiceImpl produitService;
	
	// AJOUTER UN NOUVEAU PRODUIT
	@PostMapping("/produit.create") 
	public ResponseEntity<Produit> createProduit(@RequestBody Produit produit) 
	{
		return this.produitService.create(produit);
	}
	
	// SELECTIONNER LA LISTE DET TOUS LES PRODUITS
	@GetMapping("/produit.index")
	public ResponseEntity<List<Produit>> getAllProduits(@RequestParam(required = false) String title) 
	{
		return this.produitService.findAll();
	}
	
	// SELECTIONNER UN CLIENT PAR ID
	@GetMapping("/produit.show/{id}")
	//
	public ResponseEntity<Produit> getProduitId(@PathVariable("id") long idProduit) 
	{
	    return this.produitService.findById(idProduit);
		
	}
	
	@PutMapping(path = "/produit.update/{id}",produces = { "application/json" })
	//
	public ResponseEntity<Produit> updateClient(@PathVariable("id") long id,@RequestBody Produit produit) {
		
		return this.produitService.update(produit,id);
	}
	
	
	@DeleteMapping("/produit.destroy/{id}") // public
	ResponseEntity<Produit> deleteProduit(@PathVariable("id") long id) 
	{
		return this.produitService.deleteById(id);
	}
	 
}
