package com.locadora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.locadora.entities.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {

}
