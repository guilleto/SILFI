
package Entidad;

public class Falla {
    private int id_Falla;
    private String nom_Falla;
    private String desc_Falla;

    public Falla(int id_Falla, String nom_Falla, String desc_Falla) {
        this.id_Falla = id_Falla;
        this.nom_Falla = nom_Falla;
        this.desc_Falla = desc_Falla;
    }

    public int getId_Falla() {
        return id_Falla;
    }

    public void setId_Falla(int id_Falla) {
        this.id_Falla = id_Falla;
    }

    public String getNom_Falla() {
        return nom_Falla;
    }

    public void setNom_Falla(String nom_Falla) {
        this.nom_Falla = nom_Falla;
    }

    public String getDesc_Falla() {
        return desc_Falla;
    }

    public void setDesc_Falla(String desc_Falla) {
        this.desc_Falla = desc_Falla;
    }
    
    
}
