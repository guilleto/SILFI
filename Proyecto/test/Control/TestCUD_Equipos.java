package Control;

import DAO.EquipoDAO;
import Entidad.Equipo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestCUD_Equipos {

    private boolean OPERACION_EXITOSA = true;
    private boolean OPERACION_NO_EXITOSA = false;

    public TestCUD_Equipos() {
    }

    @Test
    public void testCreate() {

        EquipoDAO daoEquipo = new EquipoDAO();
        Equipo equipo = new Equipo();
        equipo.setId_Equipo("102A");
        equipo.setNombre_Equipo("Computador Acer");
        equipo.setDescripcion_Equipo("Corei7 8gbRAM");
        equipo.setLabId_Lab("15");
        assertEquals(daoEquipo.crear(equipo), OPERACION_EXITOSA);

        equipo.setId_Equipo("169A");
        equipo.setNombre_Equipo("Computador Acer");
        equipo.setDescripcion_Equipo("Corei3 4gbRAM");
        equipo.setLabId_Lab("12");
        assertEquals(daoEquipo.crear(equipo), OPERACION_EXITOSA);

    }

    @Test
    public void testUpdate() {

        EquipoDAO daoEquipo = new EquipoDAO();
        Equipo equipo = new Equipo();
        Equipo oldEquipo = new Equipo();
        oldEquipo.setId_Equipo("102A");
        oldEquipo.setNombre_Equipo("Computador Acer");
        oldEquipo.setDescripcion_Equipo("Corei7 8gbRAM");
        oldEquipo.setLabId_Lab("15");
        
        equipo.setId_Equipo("102A");
        equipo.setNombre_Equipo("Computador Acer V2");
        equipo.setDescripcion_Equipo("Corei9 8gbRAM");
        equipo.setLabId_Lab("15");
        assertEquals(daoEquipo.actualizar(oldEquipo,equipo), OPERACION_EXITOSA);

    }

    @Test
    public void testDelete() {
        EquipoDAO daoEquipo = new EquipoDAO();
        Equipo equipo = new Equipo();

        equipo.setId_Equipo("169A");
        equipo.setNombre_Equipo("Computador Acer");
        equipo.setDescripcion_Equipo("Corei3 4gbRAM");
        equipo.setLabId_Lab("12");

        assertEquals(daoEquipo.eliminar(equipo), OPERACION_EXITOSA);

    }
    /*
    
     */
}
