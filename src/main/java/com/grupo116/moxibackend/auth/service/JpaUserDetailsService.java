package com.grupo116.moxibackend.auth.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupo116.moxibackend.dao.UsuarioDao;
import com.grupo116.moxibackend.entity.Role;
import com.grupo116.moxibackend.entity.Usuario;

@Service("jpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService{

	@Autowired
	private UsuarioDao usuarioDao;
	
	private Logger logger = LoggerFactory.getLogger(JpaUserDetailsService.class);
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Antes del DAO");
        Usuario usuario = usuarioDao.findByUsuario(username);
        System.out.println("Despues del DAO");
        if(usuario == null) {
        	logger.error("Error en el Login: no existe el usuario '" + username + "' en el sistema!");
        	throw new UsernameNotFoundException("Username: " + username + " no existe en el sistema!");
        }
        System.out.println("Usuario: " + usuario.getUsuario() + ", Passworld: " + usuario.getPassword());
        
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        
        for(Role rol: usuario.getRoles()) {
        	logger.info("Role: ".concat(rol.getRol()));
        	authorities.add(new SimpleGrantedAuthority(rol.getRol()));
        }
        
        if(authorities.isEmpty()) {
        	logger.error("Error en el Login: Usuario '" + username + "' no tiene roles asignados!");
        	throw new UsernameNotFoundException("Error en el Login: usuario '" + username + "' no tiene roles asignados!");
        }
        
        return new User(usuario.getUsuario(), usuario.getPassword(), usuario.getHabilitado(), true, true, true, authorities);
	}

}
