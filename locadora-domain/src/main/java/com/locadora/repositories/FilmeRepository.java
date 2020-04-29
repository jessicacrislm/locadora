package com.locadora.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.locadora.entities.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {

	@Query("SELECT f FROM Filme f WHERE LOWER(f.titulo) LIKE '%'||(:titulo)||'%'")
	List<Filme> findAllByTitulo(@Param("titulo") String titulo);
	
	@Query("SELECT f FROM Filme f WHERE LOWER(f.titulo) LIKE (:titulo)||'%'")
	List<Filme> findAllByInicialTitulo(@Param("titulo") String titulo);
	
	@Query("SELECT f FROM Filme f WHERE LOWER(f.genero) LIKE :genero")
	List<Filme> findAllByGenero(@Param("genero") String genero);
	
	@Query("SELECT f FROM Filme f WHERE LOWER(f.diretor) LIKE '%'||(:diretor)||'%'")
	List<Filme> findAllByDiretor(@Param("diretor") String diretor);
	
	@Query("SELECT f FROM Filme f WHERE LOWER(f.diretor) LIKE '%'||(:diretor)||'%'")
	List<Filme> findAllByInicialDiretor(@Param("diretor") String diretor);
	
	@Query("SELECT f FROM Filme f WHERE f.anoLancamento = :ano")
	List<Filme> findAllByAno(@Param("ano") int ano);
	
}
