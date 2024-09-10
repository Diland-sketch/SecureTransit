/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.secure.transitgui.entidades;

import com.mycompany.secure.transitgui.logica.LogicaUsuario;
import com.mycompany.secure.transitgui.persistencia.*;
import java.util.ArrayList;

/**
 *
 * @author OSMAR LOPEZ
 */

public class Usuario extends Persona {
    private String username;
    private String contrasena;
    private Historico historialServicios;
    

    public Usuario(String nombres, String apellidos, int id, String sexo, String correo, String contrasena, String username) {
        super(nombres, apellidos, id, sexo, correo);
        this.username = username;
        this.contrasena = contrasena;
        this.historialServicios = new Historico();
    }

    public void agregarServicio(Servicio servicio) {
        historialServicios.agregarServicio(servicio);
    }

    public ArrayList<Servicio> obtenerHistorialServicios() {
        return historialServicios.obtenerServicios();
    }

    @Override
    public int getId() {
        return super.getId();
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    @Override
    public String toString() {
        return "Usuario{" +
                "nombres='" + getNombres() + '\'' +
                ", apellidos='" + getApellidos() + '\'' +
                ", sexo='" + getSexo() + '\'' +
                ", id='" + getId() + '\'' +
                ", username=" + getUsername() +
                '}';
    }
    
    public boolean registrar(LogicaUsuario logicaUsuario) {
        return logicaUsuario.registrar(this);
    }

    public boolean iniciarSesion(LogicaUsuario logicaUsuario) {
        return logicaUsuario.login(this.username, this.getContrasena());
    }

    public Historico getHistorialServicios() {
        return historialServicios;
    }

    public void setHistorialServicios(Historico historialServicios) {
        this.historialServicios = historialServicios;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}


