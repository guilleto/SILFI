package Control;

import DAO.EquipoDAO;

import Entidad.Equipo;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestRead_Equipo extends TestCase {

    private boolean OPERACION_EXITOSA = true;
    private boolean OPERACION_NO_EXITOSA = false;

    public TestRead_Equipo() {
    }

    @Test
    public void testRead() {

        EquipoDAO dao = new EquipoDAO();
        Equipo equipo = new Equipo();

        equipo.setNombre_Equipo("Computador Lenovo");
        equipo.setDescripcion_Equipo("Corei9_8gbRAM");

        assertEquals(dao.leer(equipo), OPERACION_EXITOSA);

    }

    @Test
    public void testRead1() {

        EquipoDAO dao = new EquipoDAO();
        Equipo equipo = new Equipo();

        equipo.setNombre_Equipo("Computador Acer");
        equipo.setDescripcion_Equipo("Corei9_5gbRAM");

        assertEquals(dao.leer(equipo), OPERACION_NO_EXITOSA);

    }
}
