package com.grupo116.moxibackend.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grupo116.moxibackend.entity.DatosMoxi;

public interface DatosMoxiDao extends JpaRepository<DatosMoxi, Long>{
	
	@Query("select d from DatosMoxi d where d.idPaciente = ?1 and d.fecha between ?2 and ?3")
	public List<DatosMoxi>recuperarDatosPorPacienteYFechas(Long id, Date desde, Date hasta);
	
}
