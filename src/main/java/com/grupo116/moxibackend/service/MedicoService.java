package com.grupo116.moxibackend.service;

import com.grupo116.moxibackend.entity.Medico;

public interface MedicoService {
	
	public Medico getMedicoInfo(long id);
	
	public Boolean createMedico(Medico medico);

}
