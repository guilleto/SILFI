
package Entidad;

public class Lab {
   private int id_Lab;
   private String nombre_Lab;
   private String descripcion_Lab;
   private int edificioId_Edificio;
   private int adminUsuarioId_Usuario;

    public Lab(int id_Lab, String nombre_Lab, String descripcion_Lab, int edificioId_Edificio, int adminUsuarioId_Usuario) {
        this.id_Lab = id_Lab;
        this.nombre_Lab = nombre_Lab;
        this.descripcion_Lab = descripcion_Lab;
        this.edificioId_Edificio = edificioId_Edificio;
        this.adminUsuarioId_Usuario = adminUsuarioId_Usuario;
    }

    public int getId_Lab() {
        return id_Lab;
    }

    public void setId_Lab(int id_Lab) {
        this.id_Lab = id_Lab;
    }

    public String getNombre_Lab() {
        return nombre_Lab;
    }

    public void setNombre_Lab(String nombre_Lab) {
        this.nombre_Lab = nombre_Lab;
    }

    public String getDescripcion_Lab() {
        return descripcion_Lab;
    }

    public void setDescripcion_Lab(String descripcion_Lab) {
        this.descripcion_Lab = descripcion_Lab;
    }

    public int getEdificioId_Edificio() {
        return edificioId_Edificio;
    }

    public void setEdificioId_Edificio(int edificioId_Edificio) {
        this.edificioId_Edificio = edificioId_Edificio;
    }

    public int getAdminUsuarioId_Usuario() {
        return adminUsuarioId_Usuario;
    }

    public void setAdminUsuarioId_Usuario(int adminUsuarioId_Usuario) {
        this.adminUsuarioId_Usuario = adminUsuarioId_Usuario;
    }
   
}
