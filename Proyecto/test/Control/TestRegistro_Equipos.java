/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Equipo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestRegistro_Equipos {
    private static ValidarEquipo validarEquipo = new ValidarEquipo();
    private String LONG_NOMBRE_INCORRECTA = "Longitud nombre incorrecta";
    private String LONG_DESCRIPCION_INCORRECTA = "Longitud descripcion incorrecta";
    private String EQUIPO_AUTORIZADO = "Equipo Registrado";
 
    public TestRegistro_Equipos() {
    }
 @Test
    public void testLongitudNombre(){
    Equipo u = new Equipo();
    u.setNombre_Equipo("R");
    u.setDescripcion_Equipo("Corei5");
    assertEquals(validarEquipo.verificar_Equipo(u), LONG_NOMBRE_INCORRECTA);
    u.setNombre_Equipo("Robertodfsdfsdgdfhdefhdfhgffghfhfghfhtasdasdadasdasfdasfadfsdfsfafafadfsafar");
    u.setDescripcion_Equipo("Corei3");
    assertEquals(validarEquipo.verificar_Equipo(u), LONG_NOMBRE_INCORRECTA);
    }
    
 
     @Test
    public void testLongitudDescripcion(){
    Equipo u = new Equipo();
    u.setNombre_Equipo("ComputadorAcer");
    u.setDescripcion_Equipo("12");
    assertEquals(validarEquipo.verificar_Equipo(u), LONG_DESCRIPCION_INCORRECTA);
    u.setNombre_Equipo("ComputadorLenovo");
    u.setDescripcion_Equipo("1");
    assertEquals(validarEquipo.verificar_Equipo(u), LONG_DESCRIPCION_INCORRECTA);
    }
    
        @Test
    public void testTodoCorrecto(){
    Equipo u = new Equipo();
    
    u.setNombre_Equipo("ComputadorAcer");
    u.setDescripcion_Equipo("Corei9");

   assertEquals(validarEquipo.verificar_Equipo(u),  EQUIPO_AUTORIZADO);
    
    u.setNombre_Equipo("ComputadorAsus");
    u.setDescripcion_Equipo("Corei9");

   assertEquals(validarEquipo.verificar_Equipo(u),  EQUIPO_AUTORIZADO);
   
    }
 
 
 
}
