/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestLogin_Usuarios {

    private static ValidarLogin validarLogin = new ValidarLogin();
    private String LONG_NOMBRE_INCORRECTA = "Longitud nombre incorrecta";
    private String LONG_PASSWORD_INCORRECTA = "Longitud contraseña incorrecta";
    private String USUARIO_AUTORIZADO = "Bienvenido";

    public TestLogin_Usuarios() {
    }

    @Test
    public void testLongitudNombre() {
        Usuario u = new Usuario();
        u.setUserName("R");
        u.setPass("123456");
        assertEquals(validarLogin.verificarLogin(u), LONG_NOMBRE_INCORRECTA);
        u.setUserName("Robertodfsdfsdgdfhdefhdfhgffghfhfghfhtr");
        u.setPass("123456");
        assertEquals(validarLogin.verificarLogin(u), LONG_NOMBRE_INCORRECTA);
    }

    @Test
    public void testLongitudContraseña() {
        Usuario u = new Usuario();
        u.setUserName("Pepe");
        u.setPass("1");
        assertEquals(validarLogin.verificarLogin(u), LONG_PASSWORD_INCORRECTA);
        u.setUserName("Pepe");
        u.setPass("123456123112eqwe124141234qwrqwer324234");
        assertEquals(validarLogin.verificarLogin(u), LONG_PASSWORD_INCORRECTA);
    }

    @Test
    public void testTodoCorrecto() {
        Usuario u = new Usuario();
        u.setUserName("Juan");
        u.setPass("4321");
        assertEquals(validarLogin.verificarLogin(u), USUARIO_AUTORIZADO);

    }

}
