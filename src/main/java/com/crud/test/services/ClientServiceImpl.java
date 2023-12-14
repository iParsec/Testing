package com.crud.test.services;

import java.util.List;
import java.util.Optional;

import org.aspectj.weaver.patterns.HasMemberTypePatternForPerThisMatching;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.crud.test.entities.Client;
import com.crud.test.repositories.ClientRespository;

import jakarta.validation.Valid;

@Service
public class ClientServiceImpl extends __CrudService<Client> {

	@Autowired
	private ClientRespository clientRepository;

	@Override
	public ResponseEntity<Client> create(Client client) {
		// TODO Auto-generated method stub
		try
		{
			Client clientSave = this.clientRepository.save(client);
			
			return new ResponseEntity<>(clientSave, HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			String message = "Impossible d'enregistrer";
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header(message, message).build();
		}
	}

	@Override
	public ResponseEntity<Client> update(Client client, Long id) { 
		// TODO Auto-generated method stub
		
		Optional<Client> clientFound = this.clientRepository.findById(id);
		
		if(clientFound.isPresent())
		{
			Client clientToUpdate = clientFound.get();
			
			clientToUpdate.setNom(client.getNom());
			clientToUpdate.setPostnom(client.getPostnom());
			clientToUpdate.setAge(client.getAge());
			clientToUpdate.setPhoto(client.getPhoto());
			clientToUpdate.setSexe(client.getSexe());
			//
			this.clientRepository.save(clientToUpdate);
			
			return new ResponseEntity<>(clientToUpdate,HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<List<Client>> findAll() {
		// TODO Auto-generated method stub
		
		
		  List<Client> clients = this.clientRepository.findAll();
		  
		  if(!clients.isEmpty())
		  {
			 return new ResponseEntity<>(clients, HttpStatus.OK);
		  } 
		  else 
		  { 
			  return  ResponseEntity.noContent().build(); 
		  } 
	}

	@Override
	public ResponseEntity<Client> findById(Long id) {
		// TODO Auto-generated method stub
		
			 Optional<Client> client = this.clientRepository.findById(id);
			 
			 if(client.isPresent())
			 {
				 String message = "L'ID du client est "+ client.get().getId();
				
				 return ResponseEntity.status(HttpStatus.OK).header(message, message).body(client.get());
			 }
			 else 
			 {
				 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			 }
		
		 
	}

	@Override
	public ResponseEntity<Client> deleteById(Long id) {
		// TODO Auto-generated method stub
		try 
		  {
			 Optional<Client> client = this.clientRepository.findById(id);
			 
			 if(client.isPresent())
			 {
				 this.clientRepository.deleteById(id);
				 return new ResponseEntity<>(HttpStatus.OK);

			 }
			 else
			 {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			 }
			
		  } 
		  catch (Exception e) 
		  { 
			  return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		  } 
	}
	
	public ResponseEntity<List<Client>> maxProduit()
	{
		
		  List<Client> clients = this.clientRepository.maxProduits();
		  
		  if(!clients.isEmpty())
		  {
			 return new ResponseEntity<>(clients, HttpStatus.OK);
		  } 
		  else 
		  { 
			  return  ResponseEntity.noContent().build(); 
		  } 
		
		
		
	}
	
	public ResponseEntity<List<Client>> maxProduitWithParam(Double prix)
	{
		
		  List<Client> clients = this.clientRepository.maxProduitsWithParam(prix);
		  
		  if(!clients.isEmpty())
		  {
			 return new ResponseEntity<>(clients, HttpStatus.OK);
		  } 
		  else 
		  { 
			  return  ResponseEntity.noContent().build(); 
		  } 
		
	}

	
	
}
