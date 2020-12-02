package Control;

import DAO.LaboratorioDAO;

import Entidad.Lab;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestRead_Lab extends TestCase {

    private boolean OPERACION_EXITOSA = true;
    private boolean OPERACION_NO_EXITOSA = false;

    public TestRead_Lab() {
    }

    @Test
    public void testRead() {

        LaboratorioDAO dao = new LaboratorioDAO();
        Lab lab  = new Lab();
        lab.setId_Lab("12");
        lab.setNombre_Lab("Laboratorio Quimica A");
        lab.setDescripcion_Lab("Objetos quimica a");
        lab.setEdificioId_Edificio("1");
        lab.setUsuarioId_Usuario("Juan");

        assertEquals(dao.leer(lab), OPERACION_EXITOSA);
        
  
        lab.setId_Lab("15");
        lab.setNombre_Lab("Laboratorio Fisica A");
        lab.setDescripcion_Lab("Objetos Fisica a");
        lab.setEdificioId_Edificio("4");
        lab.setUsuarioId_Usuario("Juan");

        assertEquals(dao.leer(lab), OPERACION_NO_EXITOSA);
    }

}
