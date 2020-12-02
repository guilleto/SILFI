package Entidad;

import java.util.Date;

public class Equipo_Falla {
private int id_Equipo_Falla;
private Date fecha_Hora_Falla;
private int fallaId_Falla;
private int equipoId_Equipo;

    public Equipo_Falla(int id_Equipo_Falla, Date fecha_Hora_Falla, int fallaId_Falla, int equipoId_Equipo) {
        this.id_Equipo_Falla = id_Equipo_Falla;
        this.fecha_Hora_Falla = fecha_Hora_Falla;
        this.fallaId_Falla = fallaId_Falla;
        this.equipoId_Equipo = equipoId_Equipo;
    }

    public int getId_Equipo_Falla() {
        return id_Equipo_Falla;
    }

    public void setId_Equipo_Falla(int id_Equipo_Falla) {
        this.id_Equipo_Falla = id_Equipo_Falla;
    }

    public Date getFecha_Hora_Falla() {
        return fecha_Hora_Falla;
    }

    public void setFecha_Hora_Falla(Date fecha_Hora_Falla) {
        this.fecha_Hora_Falla = fecha_Hora_Falla;
    }

    public int getFallaId_Falla() {
        return fallaId_Falla;
    }

    public void setFallaId_Falla(int fallaId_Falla) {
        this.fallaId_Falla = fallaId_Falla;
    }

    public int getEquipoId_Equipo() {
        return equipoId_Equipo;
    }

    public void setEquipoId_Equipo(int equipoId_Equipo) {
        this.equipoId_Equipo = equipoId_Equipo;
    }

}
