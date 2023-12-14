package com.crud.test.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crud.test.entities.Commande;
import com.crud.test.repositories.CommandeRepository;

@Service
public class CommandeServiceImpl extends __CrudService<Commande> {
	
	@Autowired
	private CommandeRepository commandeRepos;
	
	@Override
	public ResponseEntity<Commande> create(Commande commande) {
		// TODO Auto-generated method stub
		try
		{
			Commande commandeSave = this.commandeRepos.save(commande);
			
			return new ResponseEntity<>(commandeSave, HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			String message = "Impossible d'enregistrer";
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header(message, message).build();
		}
	}

	@Override
	public ResponseEntity<Commande> update(Commande commande, Long id) {
		// TODO Auto-generated method stub
		Optional<Commande> commandeFound = this.commandeRepos.findById(id);
		
		if(commandeFound.isPresent())
		{
			Commande commandeToUpdate = commandeFound.get();
			
			commandeToUpdate.setClient(commande.getClient());
			//
			this.commandeRepos.save(commandeToUpdate);
			
			return new ResponseEntity<>(commandeToUpdate,HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<List<Commande>> findAll() {
		// TODO Auto-generated method stub
		  List<Commande> commandes = this.commandeRepos.findAll();
		  
		  if(!commandes.isEmpty())
		  {
			 return new ResponseEntity<>(commandes, HttpStatus.OK);
		  } 
		  else 
		  { 
			  return  ResponseEntity.noContent().build(); 
		  } 
	}

	@Override
	public ResponseEntity<Commande> findById(Long id) {
		// TODO Auto-generated method stub
		Optional<Commande> commande = this.commandeRepos.findById(id);
		 
		 if(commande.isPresent())
		 {
			 String message = "L'ID de la commande est "+ commande.get().getIdcommande();
			
			 return ResponseEntity.status(HttpStatus.OK).header(message, message).body(commande.get());
		 }
		 else 
		 {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		 }
	}

	@Override
	public ResponseEntity<Commande> deleteById(Long id) {
		// TODO Auto-generated method stub
		
			 Optional<Commande> commande = this.commandeRepos.findById(id);
			 
			 if(commande.isPresent())
			 {
				 this.commandeRepos.deleteById(id);
				 return new ResponseEntity<>(HttpStatus.OK);

			 }
			 else
			 {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			 }
			
	}

}
