package Control;

import DAO.LaboratorioDAO;

import Entidad.Equipo;
import Entidad.Lab;
import Entidad.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestCUD_Lab {

    private boolean OPERACION_EXITOSA = true;
    private boolean OPERACION_NO_EXITOSA = false;

    public TestCUD_Lab() {
    }

   // /*
    @Test
    public void testCreate() {

        LaboratorioDAO daoLab = new LaboratorioDAO();
        Lab lab = new Lab();
        lab.setId_Lab("12");
        lab.setNombre_Lab("Laboratorio Quimica");
        lab.setDescripcion_Lab("Objetos quimica");
        lab.setEdificioId_Edificio("0");
        lab.setUsuarioId_Usuario("Juan");
        assertEquals(daoLab.crear(lab), OPERACION_EXITOSA);
    
        
        lab.setId_Lab("13");
        lab.setNombre_Lab("Laboratorio Fisica");
        lab.setDescripcion_Lab("Objetos Fisica ");
        lab.setEdificioId_Edificio("0");
        lab.setUsuarioId_Usuario("Juan");
        assertEquals(daoLab.crear(lab), OPERACION_EXITOSA);

 
    }
    // */
    @Test
    public void testUpdate() {
        LaboratorioDAO daoLab = new LaboratorioDAO();
        Lab lab = new Lab();
        Lab oldLab = new Lab();
        
        oldLab.setId_Lab("12");
        oldLab.setNombre_Lab("Laboratorio Quimica");
        oldLab.setDescripcion_Lab("Objetos quimica");
        oldLab.setEdificioId_Edificio("0");
        oldLab.setUsuarioId_Usuario("Juan");
        lab.setId_Lab("12");
        lab.setNombre_Lab("Laboratorio Quimica A");
        lab.setDescripcion_Lab("Objetos quimica a");
        lab.setEdificioId_Edificio("1");
        lab.setUsuarioId_Usuario("Juan");
        assertEquals(daoLab.actualizar(oldLab, lab), OPERACION_EXITOSA);

        
        oldLab.setId_Lab("16");
        oldLab.setNombre_Lab("Laboratorio de Electronica");
        oldLab.setDescripcion_Lab("Objetos de Electro");
        oldLab.setEdificioId_Edificio("0");
        oldLab.setUsuarioId_Usuario("Juan");
        lab.setId_Lab("16");
        lab.setNombre_Lab("Laboratorio de Electronica Alternativa");
        lab.setDescripcion_Lab("Objetos de Electronica");
        lab.setEdificioId_Edificio("2");
        lab.setUsuarioId_Usuario("Juan");
       
        assertEquals(daoLab.actualizar(oldLab, lab), OPERACION_NO_EXITOSA);
         
    }
    
    @Test
    public void testDelete() {
        LaboratorioDAO daoLab = new LaboratorioDAO();
        Lab lab = new Lab();

        lab.setId_Lab("13");
        lab.setNombre_Lab("Laboratorio Fisica");
        lab.setDescripcion_Lab("Objetos Fisica ");
        lab.setEdificioId_Edificio("0");
        lab.setUsuarioId_Usuario("Juan");

        assertEquals(daoLab.eliminar(lab), OPERACION_EXITOSA);

    }
    /*
    
     */
}
