package com.grupo116.moxibackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grupo116.moxibackend.entity.Medico;

public interface MedicoDao extends JpaRepository<Medico, Long> {

//	@Query("select m from Medico m where m.id = ?1")
//	public Medico getByIdMedico(Long id);

}
