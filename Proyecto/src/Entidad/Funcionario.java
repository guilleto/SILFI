
package Entidad;

public class Funcionario {
    private int usuarioId_Usuario;
    private int adminUsuarioId_Usuario;

    public Funcionario(int usuarioId_Usuario, int adminUsuarioId_Usuario) {
        this.usuarioId_Usuario = usuarioId_Usuario;
        this.adminUsuarioId_Usuario = adminUsuarioId_Usuario;
    }

    public int getUsuarioId_Usuario() {
        return usuarioId_Usuario;
    }

    public void setUsuarioId_Usuario(int usuarioId_Usuario) {
        this.usuarioId_Usuario = usuarioId_Usuario;
    }

    public int getAdminUsuarioId_Usuario() {
        return adminUsuarioId_Usuario;
    }

    public void setAdminUsuarioId_Usuario(int adminUsuarioId_Usuario) {
        this.adminUsuarioId_Usuario = adminUsuarioId_Usuario;
    }

    
}
