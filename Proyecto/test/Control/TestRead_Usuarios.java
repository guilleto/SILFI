package Control;

import DAO.UsuarioDAO;
import Entidad.Usuario;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestRead_Usuarios extends TestCase {
    
    private boolean OPERACION_EXITOSA = true;
    private boolean OPERACION_NO_EXITOSA = false;
    
    public TestRead_Usuarios() {
    }
    
    @Test
    public void testRead() {
    
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = new Usuario();
        
        
        usuario.setUserName("Juan");
        usuario.setPass("4321");
        //usuario.setAdmin(0);
        
        assertEquals(dao.leer(usuario),OPERACION_EXITOSA);
        
        usuario.setUserName("Admin");
        usuario.setPass("12345");
        //usuario.setAdmin(1);
        assertEquals(dao.leer(usuario), OPERACION_EXITOSA);
        
        usuario.setUserName("Pepe");
        usuario.setPass("43215");
        //usuario.setAdmin(0);
        assertEquals(dao.leer(usuario),OPERACION_NO_EXITOSA);
    }
}
