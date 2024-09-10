/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.secure.transitgui.persistencia;

import com.mycompany.secure.transitgui.entidades.*;
import java.util.List;

/**
 *
 * @author OSMAR LOPEZ
 */
public interface ICrud<T> {
    boolean registrar(T persona);
    boolean eliminar(int id);
    List<T> listar();
    //T obtener(String placa);
}
