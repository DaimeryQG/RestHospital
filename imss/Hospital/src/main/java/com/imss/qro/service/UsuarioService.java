package com.imss.qro.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imss.qro.models.Usuario;
import com.imss.qro.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Metodo para ver todos los usuarios
    public List<Usuario> obtenerTodosLosUsuarios() {
        logger.info("Obteniendo todos los usuarios");
        return usuarioRepository.findAll();
    }

    // Metodo para ver los Usuarios con el ID
    public Optional<Usuario> obtenerUsuarioPorId(Integer id) {
        logger.info("Buscando usuario con ID: {}", id);
        return usuarioRepository.findById(id);
    }

    // Metodo para Crear los Usuarios
    public String registrarUsuario(Usuario usuario) {
        logger.info("Registrando un nuevo usuario");
        Usuario nuevoUsuario = usuarioRepository.save(usuario);
        if (nuevoUsuario != null) {
            logger.info("Usuario con ID {} fue creado con éxito.", nuevoUsuario.getUsuarioId());
            return "El usuario ID " + nuevoUsuario.getUsuarioId() + " fue creado con éxito.";
        } else {
            logger.error("No se pudo crear el usuario");
            return "No se pudo crear el usuario";
        }
    }

    // Metodo para Actualizar los Usuarios
    public String actualizarUsuario(Integer id, Usuario usuarioDetalles) {
        logger.info("Actualizando usuario con ID: {}", id);
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setNombre(usuarioDetalles.getNombre());
            usuario.setApellido(usuarioDetalles.getApellido());
            usuario.setFechaNacimiento(usuarioDetalles.getFechaNacimiento());
            usuario.setGenero(usuarioDetalles.getGenero());
            usuario.setCorreoElectronico(usuarioDetalles.getCorreoElectronico());
            usuario.setTelefono(usuarioDetalles.getTelefono());
            usuario.setFechaRegistro(usuarioDetalles.getFechaRegistro());
            usuario.setCURP(usuarioDetalles.getCURP());
            usuario.setRFC(usuarioDetalles.getRFC());
            usuario.setCiudad(usuarioDetalles.getCiudad());
            usuario.setDireccion(usuarioDetalles.getDireccion());
            usuario.setEstado(usuarioDetalles.getEstado());
            usuario.setEspecialidad(usuarioDetalles.getEspecialidad());
            usuario.setTipoUsuario(usuarioDetalles.getTipoUsuario());
            usuarioRepository.save(usuario);
            logger.info("Usuario con ID {} actualizado con éxito.", id);
            return "Usuario con ID " + id + " actualizado con éxito.";
        }).orElseGet(() -> {
            logger.warn("Usuario con ID {} no encontrado.", id);
            return "Usuario con ID " + id + " no se encuentra.";
        });
    }

    // Metodo para Eliminar los Usuarios
    public String eliminarUsuario(Integer id) {
        logger.info("Eliminando usuario con ID: {}", id);
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if(usuarioOptional.isPresent()) {
            usuarioRepository.deleteById(id);
            logger.info("Usuario con ID {} eliminado exitosamente.", id);
            return "El usuario con ID " + id + " fue eliminado exitosamente.";
        } else {
            logger.error("No se encontró ningun Usuario con ID {}", id);
            throw new IllegalArgumentException("No se encontró ningun Usuario con ID " + id);
        }
    }
}
