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

public class LogicaVehiculo implements ICrud<Vehiculo> {
    private List<Vehiculo> vehiculos;

    public LogicaVehiculo() {
        vehiculos = new ArrayList<>();
    }

    @Override
    public boolean registrar(Vehiculo vehiculo) {
        System.out.println("Vehículo registrado: " + vehiculo);
        return vehiculos.add(vehiculo);
    }

    @Override
    public boolean eliminar(int id) {
        System.out.println("Vehículo con ID " + id + " eliminado.");
        return vehiculos.removeIf(vehiculo -> vehiculo.getId() == id);
    }

    @Override
    public List listar() {
        System.out.println("Lista de vehículos:");
        return vehiculos;
    }

    public Vehiculo obtener(String placa) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equals(placa)) {
                return vehiculo;
            }
        }
        return null;
    }
}
