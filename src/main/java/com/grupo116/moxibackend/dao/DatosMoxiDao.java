package com.grupo116.moxibackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo116.moxibackend.entity.DatosMoxi;

public interface DatosMoxiDao extends JpaRepository<DatosMoxi, Long>{
	
}
