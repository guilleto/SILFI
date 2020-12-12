package Entidad;

import java.util.Date;

public class Equipo {

    private String id_Equipo;
    private String nombre_Equipo;
    private String descripcion_Equipo;
    private String labId_Lab;
    private String estado;
    
    public Equipo() {
    }

    public Equipo(String id_Equipo, String nombre_Equipo, String descripcion_Equipo, String labId_Lab, String estado) {
        this.id_Equipo = id_Equipo;
        this.nombre_Equipo = nombre_Equipo;
        this.descripcion_Equipo = descripcion_Equipo;
        this.labId_Lab = labId_Lab;
        this.estado = estado;
    }

    public String getId_Equipo() {
        return id_Equipo;
    }

    public void setId_Equipo(String id_Equipo) {
        this.id_Equipo = id_Equipo;
    }

    public String getNombre_Equipo() {
        return nombre_Equipo;
    }

    public void setNombre_Equipo(String nombre_Equipo) {
        this.nombre_Equipo = nombre_Equipo;
    }

    public String getDescripcion_Equipo() {
        return descripcion_Equipo;
    }

    public void setDescripcion_Equipo(String descripcion_Equipo) {
        this.descripcion_Equipo = descripcion_Equipo;
    }

    public String getLabId_Lab() {
        return labId_Lab;
    }

    public void setLabId_Lab(String labId_Lab) {
        this.labId_Lab = labId_Lab;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

  
}
