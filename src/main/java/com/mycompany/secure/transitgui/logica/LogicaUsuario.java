/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.secure.transitgui.logica;

import com.mycompany.secure.transitgui.persistencia.*;
import com.mycompany.secure.transitgui.entidades.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author OSMAR LOPEZ
 */

import java.util.ArrayList;
import java.util.List;

public class LogicaUsuario implements ICrud<Usuario> {
    private List<Usuario> usuarios = new ArrayList();


    @Override
    public boolean registrar(Usuario usuario) {
        return usuarios.add(usuario);
    }

    @Override
    public boolean eliminar(int id) {
        return usuarios.removeIf(usuario -> usuario.getId() == id);
    }

    @Override
    public List<Usuario> listar() {
        return usuarios;
    }

    public Usuario obtener(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

     public boolean login(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("usuarios.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userDetails = line.split(",");
                if (userDetails.length == 6 && userDetails[0].equals(username) && userDetails[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
    
    /*private final String USER = "Perrito";
    private final String PASSWORD = "123";
    
    public boolean login(String username, String password){
        // implementar logica para validacion de credenciales de ususario
        return (username.equals(USER)&&password.equals(PASSWORD));
        /*for(Usuario u: usuarios){
             if(u.getUsername().equals(username)&&u.getContrasena().equals(password)){
                 return true;
             }
        }
        return false;
    }
}*/
   


