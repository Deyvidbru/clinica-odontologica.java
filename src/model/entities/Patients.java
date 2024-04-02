package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Patients extends Pessoa {
    private String indication;
    private List<Consulta> consultas = new ArrayList<>();
    private List<String> evolucoes = new ArrayList<>();

    private Medico medicoResponsavel;

    public Patients() {
    }

    public Patients(String nome, String cpf, String telefone, String rua, String cidade, String estado, String indication, Medico medicoResponsavel) {
        super(nome, cpf, telefone, rua, cidade, estado);
        this.indication = indication;
        this.medicoResponsavel = medicoResponsavel;
    }

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }

    public void registrarConsulta(Consulta consulta) {
        consultas.add(consulta);
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public Consulta listarConsultas() {
        for (Consulta consulta : consultas) {
            return consulta;
        }
        return null;
    }

    public Consulta buscarConsultaPorData(String data) {
        for (Consulta consulta : consultas) {
            if (consulta.getData().equals(data)) {
                return consulta;
            }
        }
        return null;
    }

    public void adicionarEvolucao(String evolucaoPaciente) {
        evolucoes.add(evolucaoPaciente);
    }

    public List<String> listarEvolucao() {
        return evolucoes;
    }

    public List<Consulta> listarConsultasPendentes() {
        List<Consulta> consultasPendentes = new ArrayList<>();
        for (Consulta consulta : consultas) {
            if (!consulta.estaPago()) {
                consultasPendentes.add(consulta);
            }
        }
        return consultasPendentes;
    }

    public void marcarConsultaComoPago(Consulta consulta) {
        consulta.marcarComoPago();
    }

    public Medico getMedicoResponsavel() {
        return medicoResponsavel;
    }

    public void setMedicoResponsavel(Medico medicoResponsavel) {
        this.medicoResponsavel = medicoResponsavel;
    }

    public String listPatientData() {
        return "Name: " + super.getNome() + "\nCPF: " + super.getCpf() + "\nphoneNumber: " + super.getTelefone() + "\nStreet: " + super.getRua()
                + "\nCity: " + super.getCidade() + "\nState: " + super.getEstado() + "\nIndication: " + indication;
    }
}
