package Entidad;

public class Usuario {

    private int id_Usuario;
    private String userName;
    private String pass;
    private int admin;

    public Usuario(int id_Usuario, String userName, String pass, int admin) {
        this.id_Usuario = id_Usuario;
        this.userName = userName;
        this.pass = pass;
        this.admin = admin;
    }

    public Usuario() {
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public int getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
