package com.crud.test.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
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
import com.crud.test.repositories.ClientRespository;
import com.crud.test.services.ClientServiceImpl;

import jakarta.validation.Valid;
import jakarta.xml.ws.Response;


@RequestMapping(value="/crud")
@RestController
@CrossOrigin(value="*")

/*
 *  API ROUTES
 *   
 * /crud/client.index : Pour lister tous les clients 
 * /crud/client.show/{id} : Pour lister un client suivant son ID 
 * /crud/client.update/{id} : Pour modifier un client suivant son ID 
 * /crud/client.create : Pour ajouter un nouveau
 * cllient /crud/client.destroy/{id} : Pour supprimer un client suivant son ID
 */

@Validated
public class ClientController {
	
	@Autowired
	private ClientServiceImpl clientService;

	@PostMapping(path="/client.create",produces = { "application/json" })
	public ResponseEntity<Client> createClient(@Valid @RequestBody Client client) {
		return clientService.create(client);
	}

	@PutMapping(path="/client.update/{id}",produces = { "application/json" })
	public ResponseEntity<Client> updateClient(@RequestBody Client client, @PathVariable Long id) {
		return clientService.update(client, id);
	}

	@GetMapping("/client.index")
	public ResponseEntity<List<Client>> getAllClients() {
		return clientService.findAll();
	}

	@GetMapping("/client.show/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable Long id) {
		return clientService.findById(id);
	}

	@DeleteMapping("/client.destroy/{id}")
	public ResponseEntity<Client> deleteClientById(@PathVariable Long id) {
		return clientService.deleteById(id);
	} 
	
	@GetMapping("/client.maxProduits")
	public ResponseEntity<List<Client>> maxProduits()
	{
		return this.clientService.maxProduit();
	}
	
	@GetMapping("/client.maxProduitsParam")
	public ResponseEntity<List<Client>> maxProduitsWithParam(@RequestParam(value = "prix", required = true) Double prix)
	{
		return this.clientService.maxProduitWithParam(prix);
	}

}
