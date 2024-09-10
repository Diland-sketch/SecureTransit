/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.secure.transitgui.entidades;

/**
 *
 * @author OSMAR LOPEZ
 */
public abstract class Persona {
    private String nombres;
    private String apellidos;
    private int id;
    private String sexo;
    private String correo;

    public Persona(String nombres, String apellidos, int id, String sexo, String correo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.id = id;
        this.sexo = sexo;
        this.correo = correo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombres=" + nombres + ", apellidos=" + apellidos + ", id=" + id + ", sexo=" + sexo + ", correo=" + correo + '}';
    }
    
}

