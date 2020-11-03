
package Control;

import DAO.EquipoDAO;
import Entidad.Equipo;
import java.util.Date;

public class ValidarEquipo {
    private EquipoDAO daoEquipo = new EquipoDAO();
     Equipo equipo = new Equipo();
    public ValidarEquipo(){}
 
     public String verificarEquipo(String id, String nombreEquipo, String descripcion, String mantenimiento, int labEquipo) {
        if(!verificarLongitudNombre(nombreEquipo)){
            return("Longitud nombre incorrecta");
        }
        if(!verificarLongitudDescripcion(descripcion)){
            return("Longitud descripcion incorrecta");
        }
        /*
        if(!verificarLaboratorio(equipo.getLabId_Lab())){
            return("Laboratorio No Encontrado");
        }
        */
       
       else{
            equipo.setId_Equipo(id);
            equipo.setNombre_Equipo(nombreEquipo);
            equipo.setDescripcion_Equipo(descripcion);
            equipo.setMantenimiento(mantenimiento);
            equipo.setLabId_Lab(labEquipo);
            
            daoEquipo.crear(equipo);
            return "Equipo Registrado";
        
        }
      
    }
    private boolean verificarLongitudNombre(String nombreEquipo) {
         return (nombreEquipo.length() > 1 && nombreEquipo.length() <= 30);
    }

    private boolean verificarLongitudDescripcion(String descripcion_Equipo) {
        return (descripcion_Equipo.length() > 1 && descripcion_Equipo.length() <= 255);
    }
 

   

 
}
