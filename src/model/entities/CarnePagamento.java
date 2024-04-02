package model.entities;

import java.time.LocalDate;

public class CarnePagamento {
	private String nomePaciente;
	private double valorConsulta;
	private String dataVencimento;
	
	public CarnePagamento() {
	}

	public CarnePagamento(String nomePaciente, double valorConsulta, String dataVencimento) {
		this.nomePaciente = nomePaciente;
		this.valorConsulta = valorConsulta;
		this.dataVencimento = dataVencimento;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public double getValorConsulta() {
		return valorConsulta;
	}

	public void setValorConsulta(double valorConsulta) {
		this.valorConsulta = valorConsulta;
	}

	public String getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	public String toString() {
		return "\nNome do Paciente: " + 
				nomePaciente+
			    "\nValor da Consulta: " + 
				valorConsulta+
			    "\nData de Vencimento: " + 
				LocalDate.parse(dataVencimento, Consulta.fmt);
	}
}
