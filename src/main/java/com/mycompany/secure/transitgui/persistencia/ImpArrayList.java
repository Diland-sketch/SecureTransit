/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.secure.transitgui.persistencia;

import com.mycompany.secure.transitgui.entidades.Persona;
import com.mycompany.secure.transitgui.entidades.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author OSMAR LOPEZ
 */
public class ImpArrayList implements ICrud<Persona> {
    
    private List<Usuario> listaUsuarios;
    
    public ImpArrayList(){
        listaUsuarios = new ArrayList();
    }

    @Override
    public boolean registrar(Persona persona) {
        return this.listaUsuarios.add((Usuario) persona);
    }

    @Override
    public boolean eliminar(int id) {
        for(Usuario u: this.listaUsuarios){
            if(u.getId() == id){
                return this.listaUsuarios.remove(u);
            }
        }
        return false;
    }

    @Override
    public List listar() {
        return this.listaUsuarios;
        
    }

    public Persona obtener(int id) {
        for(Usuario u: this.listaUsuarios){
            if(u.getId() == id){
                return u;
            }
        }
        return null;
    }

}
