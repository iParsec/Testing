package com.crud.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.test.entities.Commande;

public interface CommandeRepository extends JpaRepository<Commande,Long> {

}
