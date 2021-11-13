package com.grupo116.moxibackend.service;

import java.util.Date;
import java.util.List;

import com.grupo116.moxibackend.entity.DatosMoxi;

public interface MoxiService {
	
	public Boolean guardarDatosDeMoxi(DatosMoxi datos);
	
	public List<DatosMoxi> obtenerDatosMoxi(Long idPaciente, Date fechaDesde, Date fechaHasta);
}
