package com.grupo116.moxibackend.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo116.moxibackend.dao.MedicoDao;
import com.grupo116.moxibackend.entity.Medico;

@Service
public class MedicoServiceImpl implements MedicoService{
	
	@Autowired
	private MedicoDao medicoDao;
	
	private static final Logger log = LogManager.getLogger(MedicoServiceImpl.class);

	@Override
	public Medico getMedicoInfo(long id) {
		
		//Medico medico = getMedicoById(id);
		
		Medico medico = medicoDao.getById(Long.valueOf(id));
		
		return medico;
	}

	@Override
	public Boolean createMedico(Medico medico) {
		try {
			medicoDao.save(medico);
		} catch (Exception e) {
			log.error("Error al tratar de crear el medico: " +e.getMessage());
			return false;
		}
		return true;
		
	}
	
	// Provisorio... se saca cuando armamos los DAO
	/*
	 * private Medico getMedicoById(long id) { List<Medico> listaDeMedicos = new
	 * ArrayList<Medico>();
	 * 
	 * listaDeMedicos.add(new Medico(1234L, "gabon", "aassddff", "Gabriel",
	 * "Rodriguez","133124D", "Cardiologia", "gab@medico.com", "1144344353",
	 * "Cabildo 650, CABA")); listaDeMedicos.add(new Medico(1225L, "arielon",
	 * "aassddff", "Ariel", "Sandoval","135644D", "Neurologia", "ariel@medico.com",
	 * "1143444353", "Av de Mayo 1234, Ramos Mejia")); listaDeMedicos.add(new
	 * Medico(1275L, "dami", "adasd123d", "Damian", "Vinci","1331324D",
	 * "Ginecologia", "dami@medico.com", "1148944353", "Juan B. Justo 90, CABA"));
	 * 
	 * Iterator<Medico> itrMedicos = listaDeMedicos.iterator();
	 * 
	 * while(itrMedicos.hasNext()) { Medico actual = itrMedicos.next(); if (id ==
	 * actual.getId()) { return actual; } } return null; }
	 */

}
