package com.grupo116.moxibackend.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "datos_moxi")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DatosMoxi implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	
	@Column(name = "id_moxi")
	@JsonProperty("id_moxi")
	private Long idMoxi;
	
	@Column(name = "id_paciente")
	@JsonProperty("id_paciente")
	private Long idPaciente;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "es-AR", timezone = "GMT-3")
	private Date fecha;
	
	@Column
	private String saturacion;
	
	@Column
	private String temperatura;
	
	@Column
	private String pulsaciones;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getSaturacion() {
		return saturacion;
	}

	public void setSaturacion(String saturacion) {
		this.saturacion = saturacion;
	}

	public String getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}

	public String getPulsaciones() {
		return pulsaciones;
	}

	public void setPulsaciones(String pulsaciones) {
		this.pulsaciones = pulsaciones;
	}

	public Long getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}

	
	public Long getIdMoxi() {
		return idMoxi;
	}

	public void setIdMoxi(Long idMoxi) {
		this.idMoxi = idMoxi;
	}

	public DatosMoxi() {
	}

	public DatosMoxi(Long id, Long idMoxi, Long idPaciente, Date fecha, String saturacion, String temperatura,
			String pulsaciones) {
		this.id = id;
		this.idMoxi = idMoxi;
		this.idPaciente = idPaciente;
		this.fecha = fecha;
		this.saturacion = saturacion;
		this.temperatura = temperatura;
		this.pulsaciones = pulsaciones;
	}
	

}
