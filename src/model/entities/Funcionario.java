package model.entities;

public class Funcionario extends Pessoa {
    private int codigoFuncionario;
    private double salario;

    public Funcionario() {
    	super();
    }

    public Funcionario(String nome, String cpf, String telefone, String rua, String cidade, String estado,
                       int codigoFuncionario, double salario) {
        super(nome, cpf, telefone, rua, cidade, estado);
        this.codigoFuncionario = codigoFuncionario;
        this.salario = salario;
    }

    public int getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(int codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCódigo do Funcionário = " + codigoFuncionario + "\nSalário = " + salario;
    }
}
