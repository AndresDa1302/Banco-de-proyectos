/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.Rol;
import edu.eci.cvds.samples.entities.Usuario;
import java.util.List;

/**
 *
 * @author Andres Gonzalez
 */
public interface ServiciosBanco {
    /**
     * Retorna el usuario segun sus credenciales
     * @param correo String correo del usuario
     * @param clave String contraseña del usuario
     * @return Usuario usuario
     * @throws edu.eci.cvds.samples.services.ExcepcionServiciosBanco
     */
    public abstract Usuario consultarUsuario(String correo, String clave) throws ExcepcionServiciosBanco;
    /**
     * 
     * @return Lista de usuarios
     * @throws ExcepcionServiciosBanco 
     */
    public abstract List<Usuario> consultarUsuarios() throws ExcepcionServiciosBanco;
    /**
     * Cambia el rol del usuario
     * @param correo correo del usuario
     * @param rol nuevo rol
     * @throws ExcepcionServiciosBanco 
     */
    public abstract void cambiarRol(String correo,Rol rol) throws ExcepcionServiciosBanco;
}
