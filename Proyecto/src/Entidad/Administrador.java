/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

public class Administrador {
   private int usuarioId_Usuario;

    public Administrador(int usuarioId_Usuario) {
        this.usuarioId_Usuario = usuarioId_Usuario;
    }

    public Administrador() {
        
    }

    public int getUsuarioId_Usuario() {
        return usuarioId_Usuario;
    }

    public void setUsuarioId_Usuario(int usuarioId_Usuario) {
        this.usuarioId_Usuario = usuarioId_Usuario;
    }
    
   
}
