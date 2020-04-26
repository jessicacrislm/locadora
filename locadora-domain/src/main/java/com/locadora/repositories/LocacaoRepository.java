package com.locadora.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.locadora.entities.Filme;
import com.locadora.entities.Locacao;
import com.locadora.entities.Usuario;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

	@Query("SELECT l FROM Locacao l WHERE l.dataDevolucao>=(:date)")
	List<Locacao> findLocacoesAbertas(@Param("date") LocalDateTime dataAtual);

	@Query("SELECT l FROM Locacao l WHERE l.filme.id=(:id)")
	List<Locacao> findAllByFilme(@Param("id") Long id);

	@Query("SELECT l FROM Locacao l WHERE l.usuario.id=(:id)")
	List<Locacao> findAllByUsuario(@Param("id") Long id);

	@Query("SELECT l FROM Locacao l WHERE l.filme=(:filme) and (l.status = 'ABERTO')")
	List<Locacao> countByFilme(@Param("filme") Filme filme);

	@Query("SELECT l FROM Locacao l WHERE l.usuario = (:user) and (l.status = 'ABERTO')")
	List<Locacao> countByUsuario(@Param("user") Usuario usuario);

	@Query("SELECT l from Locacao l WHERE l.status = 'RENOVADO' AND l.id = (:locacao)")
	List<Locacao> findRenovacoesByLocacao(@Param("locacao") Long locacao);
}
