/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.secure.transitgui.entidades;
import java.time.LocalDate;

/**
 *
 * @author OSMAR LOPEZ
 */
    
public class Servicio {
    private LocalDate fecha;
    private String nombreConductor;
    private int id;

    public Servicio(LocalDate fecha, String nombreConductor, int id) {
        this.fecha = fecha;
        this.nombreConductor = nombreConductor;
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNombreConductor() {
        return nombreConductor;
    }

    public void setNombreConductor(String nombreConductor) {
        this.nombreConductor = nombreConductor;
    }
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}

