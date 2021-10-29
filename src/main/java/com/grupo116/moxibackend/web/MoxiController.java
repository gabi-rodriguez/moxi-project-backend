package com.grupo116.moxibackend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo116.moxibackend.entity.DatosMoxi;
import com.grupo116.moxibackend.service.MoxiService;

@RestController
@RequestMapping("/moxi")
public class MoxiController {
	
	@Autowired
	private MoxiService moxiService;

	@PostMapping(value = "/datos", consumes = "application/json")
	public ResponseEntity<DatosMoxi> addDatosMoxi(@RequestBody DatosMoxi datosMoxi) {
		Boolean datosGuardados = moxiService.guardarDatosDeMoxi(datosMoxi);
		if (datosGuardados) {
			return ResponseEntity.ok(null);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}
}
