package model.entities;

public class Pessoa {
	private String nome;
    private String cpf;
    private String telefone;
    private String rua;
    private String cidade;
    private String estado;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, String telefone, String rua, String cidade, String estado) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "Nome = " + nome + "\nCpf = " + cpf + "\nTelefone = " + telefone +
                "\nRua = " + rua + "\nCidade = " + cidade + "\nEstado = " + estado;
    }
}
