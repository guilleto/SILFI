package Control;

import DAO.PerifericoDAO;
import Entidad.Periferico;

public class ValidarPeriferico {

    private PerifericoDAO daoPer = new PerifericoDAO();
    Periferico periferico = new Periferico();

    public ValidarPeriferico() {
    }

    public String verificarPeriferico(String id, String nombre, String descripcion, String equipo , String estado, String estadoDescripcion) {
        if (!verificarLongitudId(id)) {
            return ("Longitud id incorrecta");
        }       
        if (!verificarLongitudNombre(nombre)) {
            return ("Longitud nombre incorrecta");
        }
        if (!verificarLongitudDescripcion(descripcion)) {
            return ("Longitud descripcion incorrecta");
        } else {
            periferico.setId_Periferico(id);
            periferico.setNombre_Periferico(nombre);
            periferico.setDescripcion(descripcion);
            periferico.setEquipoId_Equipo(equipo);
            periferico.setEstado(estado);
            periferico.setEstadoDescripcion(estadoDescripcion);
            if (daoPer.crear(periferico) == false) {
                return "Periferico Invalido";
            }
            return "Periferico Registrado";

        }

    }

    private boolean verificarLongitudNombre(String nombreEquipo) {
        return (nombreEquipo.length() > 1 && nombreEquipo.length() <= 30);
    }
    private boolean verificarLongitudId(String id) {
        return (id.length() > 0 && id.length() <= 30);
    }

    private boolean verificarLongitudDescripcion(String descripcion_Equipo) {
        return (descripcion_Equipo.length() > 3 && descripcion_Equipo.length() <= 255);
    }

 

}
