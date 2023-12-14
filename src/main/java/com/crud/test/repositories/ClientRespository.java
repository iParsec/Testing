package com.crud.test.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.crud.test.entities.Client;


public interface ClientRespository extends JpaRepository<Client,Long> {
	

	@Query(value="SELECT * FROM client", nativeQuery=true) 
	ArrayList<Client> allClients();  
	  
	// LISTE DES CLIENTS DONT LES PRIX PRODUITS COMMANDES SONT SUP A 1000
	@Query(value="SELECT * FROM client c INNER JOIN commande co ON  c.id=co.client_id INNER JOIN produit p ON co.idcommande=p.commande_id WHERE p.prix > 1000",nativeQuery=true)
	List<Client> maxProduits();
	  
	// LISTE DES CLIENTS DONT LES PRIX PRODUITS COMMANDES SONT SUP AVEC PARAMETRE
    
	
	//@Query(value="SELECT * FROM client c INNER JOIN commande co ON  c.id=co.client_id INNER JOIN produit p ON co.idcommande=p.commande_id WHERE p.prix > ?1",nativeQuery=true)
	
	
	
	
	@Query("SELECT c FROM Client c "
            + "JOIN c.commandes co "
            + "JOIN co.produits p "
            + "WHERE p.prix = :prix")
	List<Client> maxProduitsWithParam(Double prix);
	 
}
