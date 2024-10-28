package com.foliaco.app.task_aop.service;

import com.foliaco.app.task_aop.model.Usuario;

public interface UsuarioService {
    Usuario getCurrentUser();
    String getCurrentUsername();

}
