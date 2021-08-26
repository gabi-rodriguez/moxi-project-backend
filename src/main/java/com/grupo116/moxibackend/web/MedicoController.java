package com.grupo116.moxibackend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo116.moxibackend.entity.Medico;
import com.grupo116.moxibackend.service.MedicoService;

@RestController
@RequestMapping("/medico")
public class MedicoController {
	
	@Autowired
	private MedicoService medicoService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Medico> getMedicoInfo(@PathVariable(value = "id") long id) {
		Medico medico = medicoService.getMedicoInfo(id);
		if(medico != null) {
			return ResponseEntity.ok(medico);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

}
