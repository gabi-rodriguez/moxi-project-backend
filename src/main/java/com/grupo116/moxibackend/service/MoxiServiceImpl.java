package com.grupo116.moxibackend.service;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo116.moxibackend.dao.DatosMoxiDao;
import com.grupo116.moxibackend.dao.DispositivoMoxiDao;
import com.grupo116.moxibackend.entity.DatosMoxi;
import com.grupo116.moxibackend.entity.DispositivoMoxi;

@Service
public class MoxiServiceImpl implements MoxiService {
	
	@Autowired
	private DatosMoxiDao datosDao;
	
	@Autowired
	private DispositivoMoxiDao dispositivoMoxiDao;
	
	private static final Logger log = LogManager.getLogger(MoxiServiceImpl.class);

	@Override
	public Boolean guardarDatosDeMoxi(DatosMoxi datos) {
		try {
			datosDao.save(datos);
		} catch (Exception e) {
			log.error("Error al tratar de guardar los datos del dispositivo " + datos.getId() + ". Detalles: "+e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public List<DatosMoxi> obtenerDatosMoxi(Long idPaciente, Date fechaDesde, Date fechaHasta) {
		return datosDao.recuperarDatosPorPacienteYFechas(idPaciente, fechaDesde, fechaHasta);
	}

	@Override
	public Boolean esDireccionMacValida(String mac) {
		DispositivoMoxi moxi; 
		
		moxi = dispositivoMoxiDao.findByMac(mac);
		if (moxi != null && mac.equals(moxi.getMac())) {
			return true;
		}
		return false;
	}

}
