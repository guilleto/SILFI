
package Entidad;

public class Periferico {
   private int id_Periferico;
   private String tipo_Periferico;
   private String marca;
   private int equipoId_Equipo;

    public Periferico(int id_Periferico, String tipo_Periferico, String marca, int equipoId_Equipo) {
        this.id_Periferico = id_Periferico;
        this.tipo_Periferico = tipo_Periferico;
        this.marca = marca;
        this.equipoId_Equipo = equipoId_Equipo;
    }

    public int getId_Periferico() {
        return id_Periferico;
    }

    public void setId_Periferico(int id_Periferico) {
        this.id_Periferico = id_Periferico;
    }

    public String getTipo_Periferico() {
        return tipo_Periferico;
    }

    public void setTipo_Periferico(String tipo_Periferico) {
        this.tipo_Periferico = tipo_Periferico;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getEquipoId_Equipo() {
        return equipoId_Equipo;
    }

    public void setEquipoId_Equipo(int equipoId_Equipo) {
        this.equipoId_Equipo = equipoId_Equipo;
    }
   
}
