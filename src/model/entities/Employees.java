package model.entities;

public class Employees extends Pessoa{
	private double salario;
    private String funcao;
    
	public Employees() {
		super();
	}
	
	public Employees(String nome, String cpf, String telefone, String rua, String cidade, String estado, double salario, String funcao) {
		super(nome, cpf, telefone, rua, cidade, estado);
		this.salario = salario;
	    this.funcao = funcao;
	}
	
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	@Override
	public String toString() {
		return "Name: " + super.getNome() + "\nCPF: " + super.getCpf() + "\nphoneNumber: " + super.getTelefone() + "\nStreet: " + super.getRua()
	    + "\nCity: " + super.getCidade() + "\nState: " + super.getEstado() + "Salario = " + salario + "\nFuncao = " + funcao;
	}
}
