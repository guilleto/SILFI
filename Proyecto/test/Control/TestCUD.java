
package Control;

import DAO.EquipoDAO;
import DAO.UsuarioDAO;
import Entidad.Equipo;
import Entidad.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestCUD {
    private boolean OPERACION_EXITOSA = true;
    private boolean OPERACION_NO_EXITOSA = false;
    public TestCUD() {
    }
    
    @Test
    public void testCreate() {
    
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = new Usuario();
        
        usuario.setUserName("Juan");
        usuario.setPass("1234");
        assertEquals(dao.crear(usuario),OPERACION_EXITOSA);
        
        
        
        EquipoDAO daoEquipo = new EquipoDAO();
        Equipo equipo = new Equipo("13ABCd");
        equipo.setNombre_Equipo("Computador Acer");
        equipo.setDescripcion_Equipo("Computador core i7, 8gb de Ram");
        equipo.setMantenimiento("2000-01-01");
     //   equipo.setLabId_Lab(2);
        assertEquals(daoEquipo.crear(equipo),OPERACION_EXITOSA);
        
    }
    
  
}
