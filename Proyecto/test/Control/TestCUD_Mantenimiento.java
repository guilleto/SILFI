package Control;

import DAO.MantenimientoDAO;

import Entidad.Mantenimiento;
import Entidad.Lab;
import Entidad.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestCUD_Mantenimiento {

    private boolean OPERACION_EXITOSA = true;
    private boolean OPERACION_NO_EXITOSA = false;

    public TestCUD_Mantenimiento() {
    }

    //
    @Test
    public void testCreate() {

        MantenimientoDAO daoMant = new MantenimientoDAO();
        Mantenimiento mant = new Mantenimiento();
        mant.setFecha_Mantenimiento("2010-01-01");
        mant.setNombre_Mantenimiento("Mantenimiento");
        mant.setDescripcion_Mantenimiento("Formateo de equipos");
        mant.setId_equipo("101A");
        mant.setId_periferico("10001");
        assertEquals(daoMant.crear(mant), OPERACION_EXITOSA);

        mant.setFecha_Mantenimiento("2011-01-01");
        mant.setNombre_Mantenimiento("Mantenimiento Computadores ASUS");
        mant.setDescripcion_Mantenimiento("Formateo de equipos");
        mant.setId_equipo("101A");
        mant.setId_periferico("10002");
        assertEquals(daoMant.crear(mant), OPERACION_EXITOSA);

    }

    @Test
    public void testUpdate() {
        MantenimientoDAO daoMant = new MantenimientoDAO();
        Mantenimiento mant = new Mantenimiento();
        Mantenimiento oldMant = new Mantenimiento();

        oldMant.setFecha_Mantenimiento("2010-01-01");
        oldMant.setNombre_Mantenimiento("Mantenimiento");
        oldMant.setDescripcion_Mantenimiento("Formateo de equipos");
        oldMant.setId_equipo("101A");
        oldMant.setId_periferico("10001");
        mant.setFecha_Mantenimiento("2010-01-01");
        mant.setNombre_Mantenimiento("Mantenimiento Computadores ACER");
        mant.setDescripcion_Mantenimiento("Formateo de equipos");
        mant.setId_equipo("101A");
        mant.setId_periferico("10003");
        assertEquals(daoMant.actualizar(oldMant, mant), OPERACION_EXITOSA);

        oldMant.setFecha_Mantenimiento("2010-01-01");
        oldMant.setNombre_Mantenimiento("MantenimientO de Computadores");
        oldMant.setDescripcion_Mantenimiento("Formateo de equipos A");
        oldMant.setId_equipo("101A");
        oldMant.setId_periferico("10001");
        mant.setFecha_Mantenimiento("2010-01-01");
        mant.setNombre_Mantenimiento("Mantenimiento Computadores");
        mant.setDescripcion_Mantenimiento("Formateo de equipos");
        mant.setId_equipo("101A");
        mant.setId_periferico("10003");
        assertEquals(daoMant.actualizar(oldMant, mant), OPERACION_NO_EXITOSA);

    }

    @Test
    public void testDelete() {
        MantenimientoDAO daoMant = new MantenimientoDAO();
        Mantenimiento mant = new Mantenimiento();

        mant.setFecha_Mantenimiento("2011-01-01");
        mant.setNombre_Mantenimiento("Mantenimiento Computadores ASUS");
        mant.setDescripcion_Mantenimiento("Formateo de equipos");
        mant.setId_equipo("101A");
        mant.setId_periferico("10002");
        assertEquals(daoMant.eliminar(mant), OPERACION_EXITOSA);

      

    }
}
