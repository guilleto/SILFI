
package Entidad;

public class Mantenimiento {
    private String id_Mantenimiento;
    private String fecha_Mantenimiento;
    private String nombre_Mantenimiento;
    private String descripcion_Mantenimiento;
    private String id_equipo;
    private String id_periferico;

    public Mantenimiento(String id_Mantenimiento, String fecha_Mantenimiento, String nombre_Mantenimiento, String descripcion_Mantenimiento, String id_equipo, String id_periferico) {
        this.id_Mantenimiento = id_Mantenimiento;
        this.fecha_Mantenimiento = fecha_Mantenimiento;
        this.nombre_Mantenimiento = nombre_Mantenimiento;
        this.descripcion_Mantenimiento = descripcion_Mantenimiento;
        this.id_equipo = id_equipo;
        this.id_periferico = id_periferico;
    }

    public Mantenimiento() {
       
    }

    public String getId_Mantenimiento() {
        return id_Mantenimiento;
    }

    public void setId_Mantenimiento(String id_Mantenimiento) {
        this.id_Mantenimiento = id_Mantenimiento;
    }

    public String getFecha_Mantenimiento() {
        return fecha_Mantenimiento;
    }

    public void setFecha_Mantenimiento(String fecha_Mantenimiento) {
        this.fecha_Mantenimiento = fecha_Mantenimiento;
    }

    public String getNombre_Mantenimiento() {
        return nombre_Mantenimiento;
    }

    public void setNombre_Mantenimiento(String nombre_Mantenimiento) {
        this.nombre_Mantenimiento = nombre_Mantenimiento;
    }

    public String getDescripcion_Mantenimiento() {
        return descripcion_Mantenimiento;
    }

    public void setDescripcion_Mantenimiento(String descripcion_Mantenimiento) {
        this.descripcion_Mantenimiento = descripcion_Mantenimiento;
    }

    public String getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(String id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getId_periferico() {
        return id_periferico;
    }

    public void setId_periferico(String id_periferico) {
        this.id_periferico = id_periferico;
    }
    
    
}
