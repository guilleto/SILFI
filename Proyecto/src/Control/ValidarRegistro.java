package Control;

import Entidad.Usuario;
import DAO.UsuarioDAO;

public class ValidarRegistro {

    private UsuarioDAO dao = new UsuarioDAO();
    Usuario usuario = new Usuario();

    public ValidarRegistro() {
    }

    public String verificarRegistro(String nombre, String password, Integer Admin) {
        if (!verificarLongitudNombre(nombre)) {
            return ("Longitud usuario incorrecta");
        } else if (!verificarLongitudPassword(password)) {
            return ("Longitud contraseña incorrecta");
        } 
         else if (!verificarAdmin(Admin)) {
            return ("No selecciono informacion");
        } else {
            usuario.setUserName(nombre);
            usuario.setPass(password);
            usuario.setAdmin(Admin);
            if(dao.crear(usuario)==false){
            return "Usuario Invalido";
            }
            return "Usuario Registrado";

        }

    }

    public boolean verificarLongitudNombre(String nombre) {
        return (nombre.length() > 3 && nombre.length() <= 13);
    }
    public boolean verificarAdmin(Integer admin) {
        return (null != admin);
    }

    public boolean verificarLongitudPassword(String password) {
        return (password.length() >= 3 && password.length() < 16);
    }

}
