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

public class TestCUD_Usuarios {

    private boolean OPERACION_EXITOSA = true;
    private boolean OPERACION_NO_EXITOSA = false;
    private boolean FALSE = false;
    private boolean TRUE = false;

    public TestCUD_Usuarios() {
    }

    @Test
    public void testCreate() {

        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = new Usuario();

        usuario.setUserName("Juan");
        usuario.setPass("1234");
        usuario.setAdmin(0);
        assertEquals(dao.crear(usuario), OPERACION_EXITOSA);

        usuario.setUserName("Pepe");
        usuario.setPass("1234");
        usuario.setAdmin(0);
        assertEquals(dao.crear(usuario), OPERACION_EXITOSA);
        
        usuario.setUserName("Admin");
        usuario.setPass("12345");
        usuario.setAdmin(1);
        assertEquals(dao.crear(usuario), OPERACION_EXITOSA);
    }

    @Test
    public void testUpdate() {

        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = new Usuario();
        Usuario oldUsuario = new Usuario();

        usuario.setUserName("Henry");
        usuario.setPass("1234");
        oldUsuario.setUserName("Henry");
        oldUsuario.setPass("123");
        assertEquals(dao.actualizar(oldUsuario, usuario), OPERACION_NO_EXITOSA);

        usuario.setUserName("Juan");
        usuario.setPass("4321");
        oldUsuario.setUserName("Juan");
        oldUsuario.setPass("1234");
        assertEquals(dao.actualizar(oldUsuario, usuario), OPERACION_EXITOSA);

    }

    @Test
    public void testDelete() {

        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = new Usuario();

        usuario.setUserName("Henry");
        usuario.setPass("1234");
        assertEquals(dao.eliminar(usuario), OPERACION_NO_EXITOSA);

        usuario.setUserName("Pepe");
        usuario.setPass("1234");
        assertEquals(dao.eliminar(usuario), OPERACION_EXITOSA);

    }

}
