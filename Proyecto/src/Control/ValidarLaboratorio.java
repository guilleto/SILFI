package Control;

import DAO.LaboratorioDAO;
import Entidad.Lab;
import java.util.Date;

public class ValidarLaboratorio {

    private LaboratorioDAO daoLab = new LaboratorioDAO();
    Lab lab = new Lab();

    public ValidarLaboratorio() {
    }

    public String verificarLab(String id_Lab, String nombre_Lab, String descripcion_Lab, String edificioId_Edificio, String usuarioId_Usuario) {
        if (!verificarLongitudId(id_Lab)) {
            return ("Longitud id incorrecta");
        }
        if (!verificarLongitudNombre(nombre_Lab)) {
            return ("Longitud nombre incorrecta");
        }
        if (!verificarLongitudDescripcion(descripcion_Lab)) {
            return ("Longitud descripcion incorrecta");

        }
        if (!verificarLongitudId(edificioId_Edificio)) {
            return ("Longitud id edificio incorrecta");

        }
        if (!verificarLongitudNombre(usuarioId_Usuario)) {
            return ("Longitud usuario incorrecta");

        } else {
            lab.setId_Lab(id_Lab);
            lab.setNombre_Lab(nombre_Lab);
            lab.setDescripcion_Lab(descripcion_Lab);
            lab.setUsuarioId_Usuario(usuarioId_Usuario);
            lab.setEdificioId_Edificio(edificioId_Edificio);
            if (daoLab.crear(lab) == false) {
                return "Laboratorio Invalido";
            }
            return "Laboratorio Registrado";

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
