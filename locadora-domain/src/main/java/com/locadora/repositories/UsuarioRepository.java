package com.locadora.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.locadora.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query("SELECT u FROM Usuario u WHERE LOWER(u.nome) = (:nome)")
	List<Usuario> findAllByNome(@Param("nome") String nome);
	
	@Query("SELECT u FROM Usuario u WHERE LOWER(u.cpf) = (:cpf)")
	Usuario findUsuarioByCpf(@Param("cpf") String cpf);
	
}
