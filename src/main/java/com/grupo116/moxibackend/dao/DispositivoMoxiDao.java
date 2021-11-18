package com.grupo116.moxibackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo116.moxibackend.entity.DispositivoMoxi;

public interface DispositivoMoxiDao extends JpaRepository<DispositivoMoxi, Long>{
	
	public DispositivoMoxi findByMac(String mac);
}
