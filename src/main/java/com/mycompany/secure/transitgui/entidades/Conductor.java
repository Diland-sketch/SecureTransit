/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.secure.transitgui.entidades;

import com.mycompany.secure.transitgui.persistencia.*;

/**
 *
 * @author OSMAR LOPEZ
 */
public class Conductor extends Persona {
    private String calificacion;
    private Vehiculo vehiculo;

    public Conductor(String nombres, String apellidos, int id, String sexo, String correo, Vehiculo vehiculo) {
        super(nombres, apellidos, id, sexo, correo);
        this.vehiculo = vehiculo;
    }
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public String toString() {
        return "Conductor{" + ", calificacion=" + calificacion + ", vehiculo=" + vehiculo + '}';
    }

}
