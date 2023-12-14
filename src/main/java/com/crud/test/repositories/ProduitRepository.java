package com.crud.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.test.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
