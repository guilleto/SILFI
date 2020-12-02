package Control;

import DAO.EquipoDAO;
import DAO.LaboratorioDAO;
import DAO.UsuarioDAO;
import Entidad.Administrador;
import Entidad.Equipo;
import Entidad.Lab;
import Entidad.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestCUD_Equipos_Lab_Usuario {

    private boolean OPERACION_EXITOSA = true;
    private boolean OPERACION_NO_EXITOSA = false;

    public TestCUD_Equipos_Lab_Usuario() {
    }

    @Test
    public void testCreate() {

        
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = new Usuario();
        usuario.setUserName("Juangomez");
        usuario.setPass("1234");
        usuario.setAdmin(0);
        assertEquals(dao.crear(usuario), OPERACION_EXITOSA);
        
        
        LaboratorioDAO daoLab = new LaboratorioDAO();
        Lab lab = new Lab();
        lab.setId_Lab("15");
        lab.setNombre_Lab("Laboratorio Quimica");
        lab.setDescripcion_Lab("Objetos quimica");
        lab.setEdificioId_Edificio("0");
        lab.setUsuarioId_Usuario(usuario.getUserName());
        assertEquals(daoLab.crear(lab), OPERACION_EXITOSA);
        
        
        EquipoDAO daoEquipo = new EquipoDAO();
        Equipo equipo = new Equipo("101A");
        equipo.setNombre_Equipo("Computador_Acer");
        equipo.setDescripcion_Equipo("Corei7_8gbRAM");
        equipo.setLabId_Lab(lab.getId_Lab());
        assertEquals(daoEquipo.crear(equipo), OPERACION_EXITOSA);


    }

  
    /*
    
     */
}
