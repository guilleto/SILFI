package Control;

import DAO.EquipoDAO;
import Entidad.Equipo;

public class ValidarEquipo {

    private EquipoDAO daoEquipo = new EquipoDAO();
    Equipo equipo = new Equipo();

    public ValidarEquipo() {
    }

    public String verificarEquipo(String id, String nombreEquipo, String descripcion, String labEquipo, String estado) {
        if (!verificarLongitudId(id)) {
            return ("Longitud id incorrecta");
        }       
        if (!verificarLongitudNombre(nombreEquipo)) {
            return ("Longitud nombre incorrecta");
        }
        if (!verificarLongitudDescripcion(descripcion)) {
            return ("Longitud descripcion incorrecta");
        } else {
            equipo.setId_Equipo(id);
            equipo.setNombre_Equipo(nombreEquipo);
            equipo.setDescripcion_Equipo(descripcion);
            equipo.setLabId_Lab(labEquipo);
            equipo.setEstado(estado);
            if (daoEquipo.crear(equipo) == false) {
                return "Equipo Invalido";
            }
            return "Equipo Registrado";

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

    public String verificar_Equipo(Equipo equipo) {

        if (!verificarLongitudNombre(equipo.getNombre_Equipo())) {
            return ("Longitud nombre incorrecta");
        }
        if (!verificarLongitudDescripcion(equipo.getDescripcion_Equipo())) {
            return ("Longitud descripcion incorrecta");
        } else {

            equipo.setNombre_Equipo(equipo.getNombre_Equipo());
            equipo.setDescripcion_Equipo(equipo.getDescripcion_Equipo());

            daoEquipo.crear(equipo);
            return "Equipo Registrado";

        }
    }

}
