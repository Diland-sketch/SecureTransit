/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.secure.transitgui.logica;

import com.mycompany.secure.transitgui.persistencia.*;
import com.mycompany.secure.transitgui.entidades.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author OSMAR LOPEZ
 */


public class LogicaConductor implements ICrud<Conductor> {
    private List<Conductor> conductores;

    public LogicaConductor() {
        conductores = new ArrayList<>();
    }
    
    public List<Conductor> getConductores() {
        return conductores;
    }

    public void setConductores(List<Conductor> conductores) {
        this.conductores = conductores;
    }

    @Override
    public boolean registrar(Conductor conductor) {
        System.out.println("Conductor registrado: " + conductor);
        return conductores.add(conductor);
    }

    @Override
    public boolean eliminar(int id) {
        System.out.println("Conductor con ID " + id + " eliminado.");
        return conductores.removeIf(conductor -> conductor.getId() == id);
    }

    @Override
    public List listar() {
        System.out.println("Lista de conductores:");
        return conductores;
    }

    public Conductor obtener(int id) {
        for (Conductor conductor : conductores) {
            if (conductor.getId()== id) {
                return conductor;
            }
        }
        return null;
    }
    
}


