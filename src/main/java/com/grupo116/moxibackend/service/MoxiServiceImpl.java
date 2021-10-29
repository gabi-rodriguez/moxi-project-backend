package com.grupo116.moxibackend.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo116.moxibackend.dao.DatosMoxiDao;
import com.grupo116.moxibackend.entity.DatosMoxi;

@Service
public class MoxiServiceImpl implements MoxiService {
	
	@Autowired
	private DatosMoxiDao datosDao;
	
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

}
