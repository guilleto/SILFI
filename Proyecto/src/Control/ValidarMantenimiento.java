package Control;

import DAO.MantenimientoDAO;

import Entidad.Mantenimiento;
import java.util.Date;

public class ValidarMantenimiento {

    private MantenimientoDAO daoMant = new MantenimientoDAO();
    Mantenimiento mant = new Mantenimiento();

    public ValidarMantenimiento() {
    }

    public String verificarMantenimiento(String fecha_Mantenimiento, String nombre_Mantenimiento,
            String descripcion_Mantenimiento, String id_equipo, String id_periferico) {
        if (!verificarLongitudId(id_equipo)) {
            return ("Longitud id equipo incorrecta");
        }
        if (!verificarLongitudId(id_periferico)) {
            return ("Longitud id periferico incorrecta");
        }
        if (!verificarLongitudDescripcion(nombre_Mantenimiento)) {
            return ("Longitud nombre incorrecta");
        }
        if (!verificarLongitudDescripcion(descripcion_Mantenimiento)) {
            return ("Longitud descripcion incorrecta");

        }
        if (!verificarLongitudNombre(fecha_Mantenimiento)) {
            return ("Longitud fecha incorrecta");

        } else {
            mant.setId_equipo(id_equipo);
            mant.setId_periferico(id_periferico);
            mant.setDescripcion_Mantenimiento(descripcion_Mantenimiento);
            mant.setFecha_Mantenimiento(fecha_Mantenimiento);
            mant.setNombre_Mantenimiento(nombre_Mantenimiento);

            if (daoMant.crear(mant) == false) {
                return "Informacion Mantenimiento Invalido";
            }
            return "Informacion Mantenimiento Registrado";
        }

    }

    private boolean verificarLongitudNombre(String nombreLab) {
        return (nombreLab.length() > 1 && nombreLab.length() <= 50);
    }

    private boolean verificarLongitudId(String id) {
        return (id.length() > 0 && id.length() <= 30);
    }


    private boolean verificarLongitudDescripcion(String descripcion_Equipo) {
        return (descripcion_Equipo.length() > 3 && descripcion_Equipo.length() <= 255);
    }

}
