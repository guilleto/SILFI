
package Entidad;
public class Usuario {
    private int id_Usuario;
    private String userName;
    private String pass;

    public Usuario(int id_Usuario, String userName, String pass) {
        this.id_Usuario = id_Usuario;
        this.userName = userName;
        this.pass = pass;
    }

    public Usuario() {
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
