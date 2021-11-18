package com.grupo116.moxibackend.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grupo116.moxibackend.entity.DatosMoxi;
import com.grupo116.moxibackend.service.MoxiService;


@RestController
@RequestMapping("/moxi")
public class MoxiController {
	
	@Autowired
	private MoxiService moxiService;

	@SuppressWarnings("rawtypes")
	@PostMapping(value = "/datos", consumes = "application/json")
	public ResponseEntity addDatosMoxi(@RequestBody DatosMoxi datosMoxi, @RequestHeader(name = "mac-address", required = false) String mac) {
		
		if (!moxiService.esDireccionMacValida(mac)) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
		}
		
		Boolean datosGuardados = moxiService.guardarDatosDeMoxi(datosMoxi);
		if (datosGuardados) {
			return ResponseEntity.ok(null);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR EN SERVER: No se pudo guardar los datos.");
	}
	
	@SuppressWarnings("rawtypes") //<---- esto se pone para
	@GetMapping("/datos/{id}")
	public ResponseEntity getDatosMoxiPorPacienteYFecha(@PathVariable(name = "id") Long id, @RequestParam(name = "desde", required = false) String fechaDesde, @RequestParam(value = "hasta", required = false) String fechaHasta) {
		
		//VALIDACION DE FECHAS------------------------------------------
		// Valido que venga OBLIGATORIAMENTE la fecha minima
		if (fechaDesde == null || (fechaDesde != null && fechaDesde.length() == 0)) {
			
			return ResponseEntity.badRequest().body("ERROR EN REQUEST: Fecha minima faltante.");
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date fechaMinima, fechaMaxima;
		try {
			fechaMinima = sdf.parse(fechaDesde);
		} catch(ParseException p) {
			return ResponseEntity.badRequest().body("ERROR EN REQUEST: Fecha minima en formato incorrecto."); 
		}
		if (fechaHasta == null) { 
			fechaMaxima = new Date();
		} else {
			
			try {
				fechaMaxima = sdf.parse(fechaHasta);
			} catch(ParseException p) {
				return ResponseEntity.badRequest().body("ERROR EN REQUEST: Fecha maxima en formato incorrecto."); 
			}
			
		}
		if (fechaMaxima.before(fechaMinima)) {
			return ResponseEntity.badRequest().body("ERROR EN REQUEST: Fecha minima es mayor a la fecha maxima."); 
		}
		//FIN VALIDACION DE FECHAS----------------------------------------
		List<DatosMoxi> listadoValores = moxiService.obtenerDatosMoxi(id, fechaMinima, fechaMaxima);
		return ResponseEntity.ok(listadoValores);
	}
}
