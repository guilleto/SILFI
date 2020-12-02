package Control;

import DAO.LaboratorioDAO;
import DAO.MantenimientoDAO;

import Entidad.Lab;
import Entidad.Mantenimiento;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestRead_Mantenimiento extends TestCase {

    private boolean OPERACION_EXITOSA = true;
    private boolean OPERACION_NO_EXITOSA = false;

    public TestRead_Mantenimiento() {
    }

    @Test
    public void testRead() {

        MantenimientoDAO daoMant = new MantenimientoDAO();
        Mantenimiento mant = new Mantenimiento();
        mant.setFecha_Mantenimiento("2010-01-01");
        mant.setNombre_Mantenimiento("Mantenimiento Computadores ACER");
        mant.setDescripcion_Mantenimiento("Formateo de equipos");
        mant.setId_equipo("101A");
        mant.setId_periferico("10003");
        assertEquals(daoMant.leer(mant), OPERACION_EXITOSA);
        
  
        mant.setFecha_Mantenimiento("2010-11-21");
        mant.setNombre_Mantenimiento("Mantenimiento Computadores ASUS V7");
        mant.setDescripcion_Mantenimiento("Formateo de equipos");
        mant.setId_equipo("101A");
        mant.setId_periferico("10003");

        assertEquals(daoMant.leer(mant), OPERACION_NO_EXITOSA);
    }

}
