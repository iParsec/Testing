package com.crud.test.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.crud.test.entities.Commande;
import com.crud.test.services.CommandeServiceImpl;

@RestController
@CrossOrigin(value="*")
@RequestMapping(value="/crud")

/*
 *  API ROUTES
 *   
 * /crud/commande.index : Pour lister tous les clients 
 * /crud/commande.show/{id} : Pour lister un client suivant son ID 
 * /crud/commande.update/{id} : Pour modifier un client suivant son ID 
 * /crud/commande.create : Pour ajouter un nouveau
 * cllient /crud/commande.destroy/{id} : Pour supprimer un client suivant son ID
 */

public class CommandeController {
	
	@Autowired
	private CommandeServiceImpl commandeService;
	

	@PostMapping(path="/commande.create",produces = { "application/json" })
	public ResponseEntity<Commande> createCommande(@RequestBody Commande commande) {
		return commandeService.create(commande);
	}

	@PutMapping(path="/commande.update/{id}",produces = { "application/json" })
	public ResponseEntity<Commande> updateCommande(@RequestBody Commande commande, @PathVariable Long id) {
		return commandeService.update(commande, id);
	}

	@GetMapping("/commande.index")
	public ResponseEntity<List<Commande>> getAllCommandes() {
		return commandeService.findAll();
	}

	@GetMapping("/commande.show/{id}")
	public ResponseEntity<Commande> getCommandeById(@PathVariable Long id) {
		return commandeService.findById(id);
	}

	@DeleteMapping("/commande.destroy/{id}")
	public ResponseEntity<Commande> deleteClientById(@PathVariable Long id) {
		return commandeService.deleteById(id);
	} 
	
}
