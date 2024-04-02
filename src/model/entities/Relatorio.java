package model.entities;

import java.util.List;

public class Relatorio {
	public static String gerarRelatorioPacientes(List<Patients> pacientes) {
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("Relatório de pacientes: \n\n");

        for (Patients paciente : pacientes) {
            relatorio.append("Nome: ").append(paciente.getNome()).append("\n");
            relatorio.append("CPF: ").append(paciente.getCpf()).append("\n");
            relatorio.append("Telefone: ").append(paciente.getTelefone()).append("\n");
            relatorio.append("Indicação: ").append(paciente.getIndication()).append("\n\n");
        }

        return relatorio.toString();
    }

    public static String gerarRelatoriosConsultas(List<Patients> pacientes) {
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("Relatório de Consultas:\n\n");

        for (Patients paciente : pacientes) {
            relatorio.append("Nome do paciente: ").append(paciente.getNome()).append("\n");
            List<Consulta> consultas = paciente.getConsultas();
            for (Consulta consulta : consultas) {
                relatorio.append("Data: ").append(consulta.getData()).append("\n");
                relatorio.append("Descrição: ").append(consulta.getDescricao()).append("\n");
                relatorio.append("Valor: ").append(consulta.getValor()).append("\n");
                relatorio.append("Pago: ").append(consulta.estaPago() ? "Sim" : "Não").append("\n");

                Medico medico = consulta.getMedico();
                if (medico != null) {
                    relatorio.append("Médico: ").append(medico.getNome()).append("\n");
                }

                relatorio.append("------------------------\n");
            }
        }

        return relatorio.toString();
    }

    public static String gerarRelatorioEvolucao(List<Patients> pacientes) {
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("Relatório de Evolução de Pacientes:\n\n");

        for (Patients paciente : pacientes) {
            relatorio.append("Nome do Paciente: ").append(paciente.getNome()).append("\n");
            List<String> evolucoes = paciente.listarEvolucao(); // Correção aqui
            for (String evolucao : evolucoes) {
                relatorio.append("Evolução: ").append(evolucao).append("\n");
            }
        }

        return relatorio.toString();
    }
}

