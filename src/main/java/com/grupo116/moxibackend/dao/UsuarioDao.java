package com.grupo116.moxibackend.dao;

import org.springframework.data.repository.CrudRepository;

import com.grupo116.moxibackend.entity.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario, Long>{

	public Usuario findByUsuario(String username);
}
