package Entidad;

public class Lab {

    private String id_Lab;
    private String nombre_Lab;
    private String descripcion_Lab;
    private String edificioId_Edificio;
    private String usuarioUsername;

    public Lab(String id_Lab, String nombre_Lab, String descripcion_Lab, String edificioId_Edificio, String usuarioId_Usuario) {
        this.id_Lab = id_Lab;
        this.nombre_Lab = nombre_Lab;
        this.descripcion_Lab = descripcion_Lab;
        this.edificioId_Edificio = edificioId_Edificio;
        this.usuarioUsername = usuarioUsername;
    }

    public Lab() {
    }

    public String getId_Lab() {
        return id_Lab;
    }

    public void setId_Lab(String id_Lab) {
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

    public String getEdificioId_Edificio() {
        return edificioId_Edificio;
    }

    public void setEdificioId_Edificio(String edificioId_Edificio) {
        this.edificioId_Edificio = edificioId_Edificio;
    }

    public String getUsuarioId_Usuario() {
        return usuarioUsername;
    }

    public void setUsuarioId_Usuario(String usuarioUsername) {
        this.usuarioUsername =usuarioUsername;
    }



}
