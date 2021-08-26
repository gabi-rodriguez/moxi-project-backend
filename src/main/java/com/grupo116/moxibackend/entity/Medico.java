package com.grupo116.moxibackend.entity;

public class Medico {
	
	private Long id;
	
	private String usuario;
	
	private String hashpass;
	
	private String nombre;
	
	private String apellido;
	
	private String matricula;
	
	private String especialidad;
	
	private String mail;
	
	private String tel;
	
	private String direccion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getHashpass() {
		return hashpass;
	}

	public void setHashpass(String hashpass) {
		this.hashpass = hashpass;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Medico(Long id, String usuario, String hashpass, String nombre, String apellido, String matricula,
			String especialidad, String mail, String tel, String direccion) {
		this.id = id;
		this.usuario = usuario;
		this.hashpass = hashpass;
		this.nombre = nombre;
		this.apellido = apellido;
		this.matricula = matricula;
		this.especialidad = especialidad;
		this.mail = mail;
		this.tel = tel;
		this.direccion = direccion;
	}
	
	public Medico(){}
}
