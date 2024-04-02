package model.entities;

import java.util.ArrayList;
import java.util.List;

public class SistemaClinica {
    private List<Patients> pacientes = new ArrayList<>();
    private List<Medico> medicos = new ArrayList<>();
    private List<Funcionario> funcionarios = new ArrayList<>();

    public void adicionarMedico(Medico medico) {
        medicos.add(medico);
    }

    public Medico buscarMedicoPorNome(String nome) {
        for (Medico medico : this.medicos) {
            if (medico.getNome().equalsIgnoreCase(nome)) {
                return medico;
            }
        }
        return null;
    }
    
    public void removerMedico(String nome) {
        Medico medicoExistente = buscarMedicoPorNome(nome);
        if (medicoExistente != null) {
            medicos.remove(medicoExistente);
        }
    }
    
    public void alterarDadosMedico(String nomeAlterarDados, String novoNome, String novoCpf, String novoTelefone,
            String novaRua, String novaCidade, String novoEstado, double novoSalario,
            String novaFuncao, String novaEspecialidade) {
			Medico medico = buscarMedicoPorNome(nomeAlterarDados);
			if (medico != null) {
			medico.setNome(novoNome);
			medico.setCpf(novoCpf);
			medico.setTelefone(novoTelefone);
			medico.setRua(novaRua);
			medico.setCidade(novaCidade);
			medico.setEstado(novoEstado);
			medico.setSalario(novoSalario);
			medico.setFuncao(novaFuncao);
			medico.setEspecialidade(novaEspecialidade);
			}
	}

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void adicionarPaciente(Patients paciente) {
        pacientes.add(paciente);
    }

    public Patients buscarPacientePorNome(String nome) {
        for (Patients paciente : this.pacientes) {
            if (paciente.getNome().equalsIgnoreCase(nome)) {
                return paciente;
            }
        }
        return null;
    }

    public void alterarDadosPaciente(String nomeAlterarDados, String novoNome, String novoCpf, String novoTelefone,
            String novaRua, String novaCidade, String novoEstado, String novaIndicacao,
            Medico novoMedicoResponsavel) {
			Patients paciente = buscarPacientePorNome(nomeAlterarDados);
			if (paciente != null) {
			paciente.setNome(novoNome);
			paciente.setCpf(novoCpf);
			paciente.setTelefone(novoTelefone);
			paciente.setRua(novaRua);
			paciente.setCidade(novaCidade);
			paciente.setEstado(novoEstado);
			paciente.setIndication(novaIndicacao);
			paciente.setMedicoResponsavel(novoMedicoResponsavel);
			}
	}

    public void removerPaciente(String nome) {
        Patients pacienteExistente = buscarPacientePorNome(nome);
        if (pacienteExistente != null) {
            pacientes.remove(pacienteExistente);
        }
    }

    public List<Patients> getPatients() {
        return pacientes;
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public Funcionario buscarFuncionarioPorCodigo(int codigo) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCodigoFuncionario() == codigo) {
                return funcionario;
            }
        }
        return null;
    }

    public void alterarDadosFuncionario(int codigoAlterarDados, String novoNome, String novoCpf, String novoTelefone,
            String novaRua, String novaCidade, String novoEstado, double novoSalario) {
        Funcionario funcionario = buscarFuncionarioPorCodigo(codigoAlterarDados);
        if (funcionario != null) {
            funcionario.setNome(novoNome);
            funcionario.setCpf(novoCpf);
            funcionario.setTelefone(novoTelefone);
            funcionario.setRua(novaRua);
            funcionario.setCidade(novaCidade);
            funcionario.setEstado(novoEstado);
            funcionario.setSalario(novoSalario);
        }
    }

    public void removerFuncionario(int codigo) {
        Funcionario funcionarioExistente = buscarFuncionarioPorCodigo(codigo);
        if (funcionarioExistente != null) {
            funcionarios.remove(funcionarioExistente);
        }
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarios;
    }
}

