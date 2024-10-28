package com.foliaco.app.task_aop.service;

import com.foliaco.app.task_aop.model.Usuario;
import org.springframework.stereotype.Service;


@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Override
    public Usuario getCurrentUser() {
        Usuario user = new Usuario();
        user.setId(1L);
        user.setUsername("admin"); 
        return user;
    }

    @Override
    public String getCurrentUsername() {
        Usuario currentUser = getCurrentUser();
        return (currentUser != null) ? currentUser.getUsername() : "Anonymous";
    }
}
