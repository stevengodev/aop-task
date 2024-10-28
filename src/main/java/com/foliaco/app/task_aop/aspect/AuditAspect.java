package com.foliaco.app.task_aop.aspect;

import com.foliaco.app.task_aop.model.Task;
import com.foliaco.app.task_aop.service.UsuarioService;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditAspect {
    private static final Logger logger = LoggerFactory.getLogger(AuditAspect.class);

    @Autowired
    @Qualifier("usuarioServiceImpl")
    private UsuarioService userService; 

    // Definir un punto de corte para métodos de creación de tareas
    @Pointcut("execution(* com.foliaco.app.task_aop.service.TaskService.createTask(..))" )
    public void createTaskPointcut() {}

    // Definir un punto de corte para métodos de eliminación de tareas
    @Pointcut("execution(* com.foliaco.app.task_aop.service.TaskService.deleteTask(..))")
    public void deleteTaskPointcut() {}

    // Advice para registrar auditoría después de crear una tarea
    @AfterReturning(pointcut = "createTaskPointcut()", returning = "task")
    public void logTaskCreation(Task task) {
        String username = userService.getCurrentUsername(); // Obtener el nombre de usuario actual
        logger.info("Usuario '" + username + "' creó la tarea con ID: " + task.getId());
    }

    // Advice para registrar auditoría después de eliminar una tarea
    @AfterReturning(pointcut = "deleteTaskPointcut()", returning = "taskId")
    public void logTaskDeletion(Long taskId) {
        String username = userService.getCurrentUsername(); // Obtener el nombre de usuario actual
        logger.info("Usuario '" + username + "' eliminó la tarea con ID: " + taskId);
    }

}
