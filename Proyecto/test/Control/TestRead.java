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

public class TestRead extends TestCase {
    
    private boolean OPERACION_EXITOSA = true;
    private boolean OPERACION_NO_EXITOSA = false;
    
    public TestRead() {
    }
    
    @Test
    public void testRead() {
    
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = new Usuario();
        
        
        usuario.setUserName("Juan");
        usuario.setPass("1234");
        assertEquals(dao.leer(usuario),OPERACION_EXITOSA);
    }
}
