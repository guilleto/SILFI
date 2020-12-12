package Entidad;

public class Periferico {

    private String Id_Periferico;
    private String Nombre_Periferico;
    private String Descripcion;
    private String equipoId_Equipo;
    private String estado;
    private String estadoDescripcion;

    public Periferico(String Id_Periferico, String Nombre_Periferico, String Descripcion, String equipoId_Equipo, String estado, String estadoDescripcion) {
        this.Id_Periferico = Id_Periferico;
        this.Nombre_Periferico = Nombre_Periferico;
        this.Descripcion = Descripcion;
        this.equipoId_Equipo = equipoId_Equipo;
        this.estado = estado;
        this.estadoDescripcion = estadoDescripcion;
    }

    public Periferico() {
      
    }

    public String getId_Periferico() {
        return Id_Periferico;
    }

    public void setId_Periferico(String Id_Periferico) {
        this.Id_Periferico = Id_Periferico;
    }

    public String getNombre_Periferico() {
        return Nombre_Periferico;
    }

    public void setNombre_Periferico(String Nombre_Periferico) {
        this.Nombre_Periferico = Nombre_Periferico;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getEquipoId_Equipo() {
        return equipoId_Equipo;
    }

    public void setEquipoId_Equipo(String equipoId_Equipo) {
        this.equipoId_Equipo = equipoId_Equipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstadoDescripcion() {
        return estadoDescripcion;
    }

    public void setEstadoDescripcion(String estadoDescripcion) {
        this.estadoDescripcion = estadoDescripcion;
    }
    
    
    

}
