
package Entidad;
public class Edificio {
    private int id_Edificio;
    private String nom_Edificio;

    public Edificio(int id_Edificio, String nom_Edificio) {
        this.id_Edificio = id_Edificio;
        this.nom_Edificio = nom_Edificio;
    }

    public int getId_Edificio() {
        return id_Edificio;
    }

    public void setId_Edificio(int id_Edificio) {
        this.id_Edificio = id_Edificio;
    }

    public String getNom_Edificio() {
        return nom_Edificio;
    }

    public void setNom_Edificio(String nom_Edificio) {
        this.nom_Edificio = nom_Edificio;
    }

    
}
