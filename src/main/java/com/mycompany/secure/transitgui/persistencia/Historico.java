/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.secure.transitgui.persistencia;

import com.mycompany.secure.transitgui.entidades.*;
import java.util.ArrayList;

/**
 *
 * @author OSMAR LOPEZ
 */

public class Historico {
    private ArrayList<Servicio> servicios;

    public Historico() {
        servicios = new ArrayList<>();
    }

    public void agregarServicio(Servicio servicio) {
        servicios.add(servicio);
    }

    public ArrayList<Servicio> obtenerServicios() {
        return servicios;
    }
}


