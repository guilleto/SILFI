
package Control;

import DAO.UsuarioDAO;
import Entidad.Usuario;

public class ValidarLogin {
    private UsuarioDAO dao = new UsuarioDAO();
    public ValidarLogin(){}
    
       public String verificarLogin(Usuario usuario){
        if(!verificarLongitudNombre(usuario.getUserName())){
            return("Longitud nombre incorrecta");
        }
        
        if(!verificarLongitudPassword(usuario.getPass())){
            return("Longitud contraseña incorrecta");
        }
        
        if(dao.leer(usuario)==true){
            return("Bienvenido");
        }
        return("Datos Incorrectos");
       }

    private boolean verificarLongitudNombre(String userName) {
         return (userName.length() > 1 && userName.length() <= 6);
    }

    private boolean verificarLongitudPassword(String pass) {
        return (pass.length() >= 3 && pass.length() < 6);
    }
       
       
    
}
