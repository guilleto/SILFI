
package Entidad;

public class Funcionario_Lab {
    private int id_Funcionario;
    private int labId_Lab;
    private int funcionarioUsuarioId_Usuario;

    public Funcionario_Lab(int id_Funcionario, int labId_Lab, int funcionarioUsuarioId_Usuario) {
        this.id_Funcionario = id_Funcionario;
        this.labId_Lab = labId_Lab;
        this.funcionarioUsuarioId_Usuario = funcionarioUsuarioId_Usuario;
    }

    public int getId_Funcionario() {
        return id_Funcionario;
    }

    public void setId_Funcionario(int id_Funcionario) {
        this.id_Funcionario = id_Funcionario;
    }

    public int getLabId_Lab() {
        return labId_Lab;
    }

    public void setLabId_Lab(int labId_Lab) {
        this.labId_Lab = labId_Lab;
    }

    public int getFuncionarioUsuarioId_Usuario() {
        return funcionarioUsuarioId_Usuario;
    }

    public void setFuncionarioUsuarioId_Usuario(int funcionarioUsuarioId_Usuario) {
        this.funcionarioUsuarioId_Usuario = funcionarioUsuarioId_Usuario;
    }
    
}
