package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Medico extends Employees {
	private String especialidade;
    private List<Consulta> consultasMarcadas = new ArrayList<>();

    public Medico() {
        super();
    }

    public Medico(String nome, String cpf, String telefone, String rua, String cidade, String estado, double salario, String funcao, String especialidade) {
        super(nome, cpf, telefone, rua, cidade, estado, salario, funcao);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void marcarConsulta(Consulta consulta, Patients paciente) {
        consultasMarcadas.add(consulta);
        paciente.registrarConsulta(consulta);
    }

    public List<Consulta> getConsultasMarcadas() {
        return consultasMarcadas;
    }

    @Override
    public String toString() {
        return super.toString() + "\nEspecialidade: " + especialidade;
    }
}

