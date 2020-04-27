package com.locadora.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.locadora.entities.Locacao;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

	@Query("SELECT l FROM Locacao l WHERE l.dataDevolucao>=(:date)")
	List<Locacao> findLocacoesAbertas(@Param("date") Date dataAtual);

	@Query("SELECT l FROM Locacao l WHERE l.filme.id=(:idFilme)")
	List<Locacao> findAllByFilme(@Param("idFilme") Long idFilme);

	@Query("SELECT l FROM Locacao l WHERE l.usuario.id=(:idUsuario)")
	List<Locacao> findAllByUsuario(@Param("idUsuario") Long idUsuario);

	@Query("SELECT count(l.id) FROM Locacao l WHERE l.filme.id=(:idFilme) and (l.status = 'ABERTO')")
	int countByFilme(@Param("idFilme") Long idFilme);

	@Query("SELECT count(l.id) FROM Locacao l WHERE l.usuario.id=(:idUsuario) and (l.status = 'ABERTO')")
	int countByUsuario(@Param("idUsuario") Long idUsuario);

	@Query("SELECT l from Locacao l WHERE l.status = 'RENOVADO' AND l.id = (:locacao)")
	List<Locacao> findRenovacoesByLocacao(@Param("locacao") Long locacao);
}
