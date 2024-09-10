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

public class LogicaServicio implements ICrud<Servicio> {
    private List<Servicio> servicios;

    public LogicaServicio() {
        servicios = new ArrayList<>();
    }

    @Override
    public boolean registrar(Servicio servicio) {
        System.out.println("Servicio registrado: " + servicio);
        return servicios.add(servicio);
    }

    @Override
    public boolean eliminar(int id) {
        System.out.println("Servicio con ID " + id + " eliminado.");
        return servicios.removeIf(servicio -> servicio.getId() == id);
    }

    @Override
    public List listar() {
        System.out.println("Lista de servicios:");
        return servicios;
    }

    public Servicio obtener(int id) {
        for (Servicio servicio : servicios) {
            if (servicio.getId() == id) {
                return servicio;
            }
        }
        return null;
    }
}
