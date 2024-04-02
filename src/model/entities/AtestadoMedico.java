package model.entities;

import java.time.LocalDate;

public class AtestadoMedico {
	private String nomePaciente;
	private String dataAtestado;
	private String descricaoMedica;
	
	public AtestadoMedico() {
	}

	public AtestadoMedico(String nomePaciente, String dataAtestado, String descricaoMedica) {
		this.nomePaciente = nomePaciente;
		this.dataAtestado = dataAtestado;
		this.descricaoMedica = descricaoMedica;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public String getDataAtestado() {
		return dataAtestado;
	}

	public void setDataAtestado(String dataAtestado) {
		this.dataAtestado = dataAtestado;
	}

	public String getDescricaoMedica() {
		return descricaoMedica;
	}

	public void setDescricaoMedica(String descricaoMedica) {
		this.descricaoMedica = descricaoMedica;
	}
	
	public String toString() {
		return "\nNome do Paciente: " + 
				nomePaciente+
				"\nData do Atestado: " + 
				LocalDate.parse(dataAtestado, Consulta.fmt)+
				"\nDescrição Médica: " + 
				descricaoMedica;
	}
}
