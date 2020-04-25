package com.locadora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.locadora.entities.Locacao;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

}
