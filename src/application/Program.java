package application;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.AtestadoMedico;
import model.entities.CarnePagamento;
import model.entities.Consulta;
import model.entities.Funcionario;
import model.entities.Medico;
import model.entities.Patients;
import model.entities.Relatorio;
import model.entities.SistemaClinica;
import model.exceptions.DomainException;
import model.util.FileHandler;
import model.util.FileHandlerLogin;

public class Program {
    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        FileHandlerLogin fileHandlerLogin = new FileHandlerLogin("dados_login.txt");
        
        System.out.println("Digite senha e login para sua segurança!");
		System.out.print("Login: ");
		String loginOutput = sc.nextLine();
		System.out.print("Password: ");
		String passwordOutput = sc.nextLine();
		
        try {
            fileHandlerLogin.clearFile(loginOutput, passwordOutput);

            SistemaClinica sistema = new SistemaClinica();
            List<Patients> patients = sistema.getPatients();
            FileHandler fileHandler = new FileHandler("data.txt");
            fileHandler.clearFile();

            while (true) {
                System.out.println("\nEscolha uma opção:");
                System.out.println("1 - Adicionar médico");
                System.out.println("2 - Alterar médico");
                System.out.println("3 - Remover médico");
                System.out.println("4 - Listar médicos");
                System.out.println("5 - Adicionar paciente");
                System.out.println("6 - Alterar paciente");
                System.out.println("7 - Remover paciente");
                System.out.println("8 - Listar pacientes"); //
                System.out.println("9 - Adicionar funcionario");
                System.out.println("10 - Alterar funcionario");
                System.out.println("11 - Remover funcionario");
                System.out.println("12 - Listar funcionarios");
                System.out.println("13 - Adicionar consulta");
                System.out.println("14 - Marcar consulta como paga");
                System.out.println("15 - Adicionar evolução do paciente");
                System.out.println("16 - Listar consultas pendentes de pagamento");
                System.out.println("17 - Listar evolução do paciente");
                System.out.println("18 - Emitir atestado médico");
                System.out.println("19 - Emitir carnê de pagamento");
                System.out.println("20 - Emitir relatórios");
                System.out.println("0 - Sair");
                
                Integer choice;
                
                try {
                    choice = sc.nextInt();
                    sc.nextLine();                 } 
                catch (InputMismatchException e) {
                    System.out.println("Por favor, insira um número válido.");
                    sc.nextLine(); 
                    continue;
                }

                String dataToSave;
                switch (choice) {
	                case 1:
					    System.out.println("Digite o nome do médico:");
					    String nomeMedico = sc.next();
					    System.out.println("Digite o CPF do médico:");
					    String cpfMedico = sc.next();
					    System.out.println("Digite o telefone do médico:");
					    String telefoneMedico = sc.next();
					    System.out.println("Digite a rua do médico:");
					    String ruaMedico = sc.next();
					    System.out.println("Digite a cidade do médico:");
					    String cidadeMedico = sc.next();
					    System.out.println("Digite o estado do médico:");
					    String estadoMedico = sc.next();
					    System.out.println("Digite o salário do médico:");
					    double salarioMedico = sc.nextDouble();
					    System.out.println("Digite a função do médico:");
					    String funcaoMedico = sc.next();
					    System.out.println("Digite a especialidade do médico:");
					    String especialidadeMedico = sc.next();
					    
					    sistema.adicionarMedico(new Medico(nomeMedico, cpfMedico, telefoneMedico, ruaMedico, cidadeMedico, estadoMedico,
					            salarioMedico, funcaoMedico, especialidadeMedico));
	
					    System.out.println("Médico adicionado com sucesso!");
					    
					    dataToSave = "Novo médico adicionado: " + nomeMedico + ", CPF: " + cpfMedico;
					    if (fileHandler.saveToFile(dataToSave)) {
					        System.out.println("Dados do novo médico salvos com sucesso no arquivo.");
					    } else {
					        System.out.println("Erro ao salvar os dados do novo médico no arquivo.");
					    }
					    break;
	                case 2:
	                	System.out.println("Digite o nome do médico para alterar seus dados:");
	                    String nomeMedicoAlterar = sc.next();
	                    Medico medicoAlterar = sistema.buscarMedicoPorNome(nomeMedicoAlterar);

	                    if (medicoAlterar != null) {
	                        System.out.println("Digite o novo nome do médico:");
	                        String novoNome = sc.next();
	                        System.out.println("Digite o novo CPF do médico:");
	                        String novoCpf = sc.next();
	                        System.out.println("Digite o novo telefone do médico:");
	                        String novoTelefone = sc.next();
	                        System.out.println("Digite a nova rua do médico:");
	                        String novaRua = sc.next();
	                        System.out.println("Digite a nova cidade do médico:");
	                        String novaCidade = sc.next();
	                        System.out.println("Digite o novo estado do médico:");
	                        String novoEstado = sc.next();
	                        System.out.println("Digite o novo salário do médico:");
	                        double novoSalario = sc.nextDouble();
	                        System.out.println("Digite a nova função do médico:");
	                        String novaFuncao = sc.next();
	                        System.out.println("Digite a nova especialidade do médico:");
	                        String novaEspecialidade = sc.next();

	                        sistema.alterarDadosMedico(nomeMedicoAlterar, novoNome, novoCpf, novoTelefone, novaRua,
	                                novaCidade, novoEstado, novoSalario, novaFuncao, novaEspecialidade);

	                        System.out.println("Dados do médico alterados com sucesso!");
	                    } else {
	                        System.out.println("Médico não encontrado.");
	                    }
	                    break;
	                case 3:
	                	List<Medico> removerMedicoList = sistema.getMedicos();
	
	                    System.out.println("Lista de Médicos:");
	                    if (removerMedicoList.isEmpty()) {
	                        System.out.println("Nenhum médico cadastrado.");
	                    } else {
	                        for (Medico medico : removerMedicoList) {
	                            System.out.println(medico);
	                        }
	
	                        System.out.print("Digite o nome do médico que deseja remover: ");
	                        String nomeMedicoRemover = sc.next();
	
	                        sistema.removerMedico(nomeMedicoRemover);
	
	                        System.out.println("Médico removido com sucesso!");
	                    }
	                    break;
	                case 4:
	                    List<Medico> medicosList = sistema.getMedicos();
	
	                    System.out.println("Lista de Médicos:");
	                    if (medicosList.isEmpty()) {
	                        System.out.println("Nenhum médico cadastrado.");
	                    } else {
	                        for (Medico medico : medicosList) {
	                            System.out.println(medico);
	                        }
	                    }
	                    break;
	
					case 5:
					    System.out.println("Digite o nome do paciente:");
					    String nomePaciente = sc.next();
					    System.out.println("Digite o CPF do paciente:");
					    String cpfPaciente = sc.next();
					    System.out.println("Digite o telefone do paciente:");
					    String telefonePaciente = sc.next();
					    System.out.println("Digite a rua do paciente:");
					    String ruaPaciente = sc.next();
					    System.out.println("Digite a cidade do paciente:");
					    String cidadePaciente = sc.next();
					    System.out.println("Digite o estado do paciente:");
					    String estadoPaciente = sc.next();
					    System.out.println("Digite a indicação do paciente:");
					    String indicacaoPaciente = sc.next();
					    System.out.println("Digite o nome do médico responsável pelo paciente:");
					    String nomeMedicoResponsavel = sc.next();
					    
					    Medico medicoResponsavel = sistema.buscarMedicoPorNome(nomeMedicoResponsavel);
	
					    if (medicoResponsavel != null) {
					        sistema.adicionarPaciente(new Patients(nomePaciente, cpfPaciente, telefonePaciente, ruaPaciente, cidadePaciente, estadoPaciente, indicacaoPaciente, medicoResponsavel));
					        System.out.println("Paciente adicionado com sucesso!");
					    } else {
					        System.out.println("Médico responsável não encontrado.");
					    }
					    
					    dataToSave = "Novo paciente adicionado: " + nomePaciente + ", CPF: " + cpfPaciente;
					    if (fileHandler.saveToFile(dataToSave)) {
					        System.out.println("Dados do novo paciente salvos com sucesso no arquivo.");
					    } else {
					        System.out.println("Erro ao salvar os dados do novo paciente no arquivo.");
					    }
					    break;
					    
					case 6:
						System.out.println("Digite o nome do paciente para alterar seus dados:");
					    String nomePacienteAlterar = sc.next();
					    Patients pacienteAlterar = sistema.buscarPacientePorNome(nomePacienteAlterar);

					    if (pacienteAlterar != null) {
					        System.out.println("Digite o novo nome do paciente:");
					        String novoNome = sc.next();
					        System.out.println("Digite o novo CPF do paciente:");
					        String novoCpf = sc.next();
					        System.out.println("Digite o novo telefone do paciente:");
					        String novoTelefone = sc.next();
					        System.out.println("Digite a nova rua do paciente:");
					        String novaRua = sc.next();
					        System.out.println("Digite a nova cidade do paciente:");
					        String novaCidade = sc.next();
					        System.out.println("Digite o novo estado do paciente:");
					        String novoEstado = sc.next();
					        System.out.println("Digite a nova indicação do paciente:");
					        String novaIndicacao = sc.next();
					        System.out.println("Digite o nome do novo médico responsável pelo paciente:");
					        nomeMedicoResponsavel = sc.next();

					        Medico novoMedicoResponsavel = sistema.buscarMedicoPorNome(nomeMedicoResponsavel);

					        if (novoMedicoResponsavel != null) {
					            sistema.alterarDadosPaciente(nomePacienteAlterar, novoNome, novoCpf, novoTelefone,
					                    novaRua, novaCidade, novoEstado, novaIndicacao, novoMedicoResponsavel);

					            System.out.println("Dados do paciente alterados com sucesso!");
					        } else {
					            System.out.println("Médico responsável não encontrado.");
					        }
					    } else {
					        System.out.println("Paciente não encontrado.");
					    }
					    break;
					case 7:
						System.out.println("Digite o nome do paciente que deseja remover: ");
					    String nomePacienteRemover = sc.next();
	
					    sistema.removerPaciente(nomePacienteRemover);
	
					    System.out.println("Paciente removido com sucesso!");
					    break;
					case 8:
					    List<Patients> pacientesList = sistema.getPatients();

					    System.out.println("Lista de Pacientes:");
					    if (pacientesList.isEmpty()) {
					        System.out.println("Nenhum paciente cadastrado.");
					    } else {
					        for (Patients paciente : pacientesList) {
					            System.out.println(paciente);
					        }
					    }
					    break;
					case 9:
					    System.out.println("Adicionar Funcionário:");
					    System.out.print("Digite o nome do funcionário: ");
					    String nomeFuncionario = sc.next();
					    System.out.print("Digite o CPF do funcionário: ");
					    String cpfFuncionario = sc.next();
					    System.out.print("Digite o telefone do funcionário: ");
					    String telefoneFuncionario = sc.next();
					    System.out.print("Digite a rua do funcionário: ");
					    String ruaFuncionario = sc.next();
					    System.out.print("Digite a cidade do funcionário: ");
					    String cidadeFuncionario = sc.next();
					    System.out.print("Digite o estado do funcionário: ");
					    String estadoFuncionario = sc.next();
					    System.out.print("Digite o código do funcionário: ");
					    int codigo = sc.nextInt();
					    System.out.print("Digite o salário do funcionário: ");
					    double salarioFuncionario = sc.nextDouble();

					    sistema.adicionarFuncionario(new Funcionario(nomeFuncionario, cpfFuncionario, telefoneFuncionario,
					            ruaFuncionario, cidadeFuncionario, estadoFuncionario, codigo, salarioFuncionario));

					    System.out.println("Funcionário adicionado com sucesso!");

					    dataToSave = "Novo funcionário adicionado: " + nomeFuncionario + ", CPF: " + cpfFuncionario;
					    if (fileHandler.saveToFile(dataToSave)) {
					        System.out.println("Dados do novo funcionário salvos com sucesso no arquivo.");
					    } else {
					        System.out.println("Erro ao salvar os dados do novo funcionário no arquivo.");
					    }
					    break;
					case 10:
						System.out.println("Alterar Dados do Funcionário:");
					    System.out.print("Digite o codigo do funcionário para alterar seus dados: ");
					    int codigoFuncionarioAlterar = sc.nextInt();
					    Funcionario funcionarioAlterar = sistema.buscarFuncionarioPorCodigo(codigoFuncionarioAlterar);

					    if (funcionarioAlterar != null) {
					        System.out.print("Digite o novo nome do funcionário: ");
					        String novoNomeFuncionario = sc.next();
					        System.out.print("Digite o novo CPF do funcionário: ");
					        String novoCpfFuncionario = sc.next();
					        System.out.print("Digite o novo telefone do funcionário: ");
					        String novoTelefoneFuncionario = sc.next();
					        System.out.print("Digite a nova rua do funcionário: ");
					        String novaRuaFuncionario = sc.next();
					        System.out.print("Digite a nova cidade do funcionário: ");
					        String novaCidadeFuncionario = sc.next();
					        System.out.print("Digite o novo estado do funcionário: ");
					        String novoEstadoFuncionario = sc.next();
					        System.out.print("Digite o novo salário do funcionário: ");
					        double novoSalarioFuncionario = sc.nextDouble();

					        sistema.alterarDadosFuncionario(funcionarioAlterar.getCodigoFuncionario(), novoNomeFuncionario,
					                novoCpfFuncionario, novoTelefoneFuncionario, novaRuaFuncionario, novaCidadeFuncionario,
					                novoEstadoFuncionario, novoSalarioFuncionario);

					        System.out.println("Dados do funcionário alterados com sucesso!");
					    } else {
					        System.out.println("Funcionário não encontrado.");
					    }
					    break;
					case 11:
						List<Funcionario> removerFuncionarioList = sistema.listarFuncionarios();

					    System.out.println("Lista de Funcionários:");
					    if (removerFuncionarioList.isEmpty()) {
					        System.out.println("Nenhum funcionário cadastrado.");
					    } else {
					        for (Funcionario funcionario : removerFuncionarioList) {
					            System.out.println(funcionario);
					        }

					        System.out.print("Digite o codigo do funcionário que deseja remover: ");
					        int codigoFuncionarioRemover = sc.nextInt();

					        sistema.removerFuncionario(codigoFuncionarioRemover);

					        System.out.println("Funcionário removido com sucesso!");
					    }
					    break;
				    
					case 12:
						List<Funcionario> funcionariosList = sistema.listarFuncionarios();

					    System.out.println("Lista de Funcionários:");
					    if (funcionariosList.isEmpty()) {
					        System.out.println("Nenhum funcionário cadastrado.");
					    } else {
					        for (Funcionario funcionario : funcionariosList) {
					            System.out.println(funcionario);
					        }
					    }
					    break;
						
					case 13:
						System.out.println("Digite o nome do médico responsável pela consulta:");
					    String nomeMedicoConsulta = sc.next();
					    Medico medicoConsulta = sistema.buscarMedicoPorNome(nomeMedicoConsulta);
					    
					    if (medicoConsulta != null) {
					        System.out.println("Digite o nome do paciente para adicionar uma consulta:");
					        String nomePacienteConsulta = sc.next();
					        Patients pacienteConsulta = sistema.buscarPacientePorNome(nomePacienteConsulta);

					        if (pacienteConsulta != null) {
					            System.out.println("Digite a data da consulta: (dd/MM/yyyy)");
					            String dataConsulta = sc.next();
					            System.out.println("Digite a descrição da consulta:");
					            String descricaoConsulta = sc.nextLine();
					            sc.nextLine();
					            System.out.println("Digite o valor da consulta:");
					            double valorConsulta = sc.nextDouble();

					            Consulta novaConsulta = new Consulta(dataConsulta, descricaoConsulta, valorConsulta, medicoConsulta);
					            pacienteConsulta.registrarConsulta(novaConsulta);
					            medicoConsulta.marcarConsulta(novaConsulta, pacienteConsulta);

					            System.out.println("Consulta registrada com sucesso.");
					            dataToSave = "Nova consulta para o paciente: " + pacienteConsulta.getNome() + ", Data: " + dataConsulta;
					            if (fileHandler.saveToFile(dataToSave)) {
					                System.out.println("Dados da nova consulta salvos com sucesso no arquivo.");
					            } else {
					                System.out.println("Erro ao salvar os dados da nova consulta no arquivo.");
					            }
					        } else {
					            System.out.println("Paciente não encontrado.");
					        }
					    } else {
					        System.out.println("Médico não encontrado.");
					    }
					    break;
					case 14:
						System.out.println("Digite o nome do paciente para marcar uma consulta como paga:");
	                    String nomePacientePagamento = sc.next();
	                    Patients pacientePagamento = sistema.buscarPacientePorNome(nomePacientePagamento);
	                    
	                    if (pacientePagamento != null) {
	                        System.out.println("Digite a data da consulta a ser marcada como paga:");
	                        String dataPagamento = sc.next();

	                        Consulta consultaPagamento = pacientePagamento.buscarConsultaPorData(dataPagamento);
	                        
	                        if (consultaPagamento != null) {
	                            consultaPagamento.marcarComoPago();
	                            System.out.println("Consulta marcada como paga com sucesso.");
	                            dataToSave = "Consulta paga na data: " + dataPagamento;
	                            if (fileHandler.saveToFile(dataToSave)) {
	                                System.out.println("Dados da consulta paga salvos com sucesso no arquivo.");
	                            } else {
	                                System.out.println("Erro ao salvar os dados da consulta paga no arquivo.");
	                            }
	                        } else {
	                            System.out.println("Consulta não encontrada.");
	                        }
	                    } else {
	                        System.out.println("Paciente não encontrado.");
	                    }  
						break;
					case 15:
						System.out.println("Digite o nome do paciente para adicionar evolução:");
	                    String nomePacienteEvolucao = sc.next();
	                    Patients pacienteEvolucao = sistema.buscarPacientePorNome(nomePacienteEvolucao);
	                    
	                    if (pacienteEvolucao != null) {
	                    	System.out.println("Digite a evolução do paciente:");
	                    	sc.nextLine(); 
	                    	String evolucaoPaciente = sc.nextLine();
	                        pacienteEvolucao.adicionarEvolucao(evolucaoPaciente);
	                        System.out.println("Evolução do paciente adicionada com sucesso.");
	                        
	                        dataToSave = "Evolução do paciente " + pacienteEvolucao.getNome() + ": " + evolucaoPaciente;
	                        if (fileHandler.saveToFile(dataToSave)) {
	                            System.out.println("Evolução do paciente salva com sucesso no arquivo.");
	                        } else {
	                            System.out.println("Erro ao salvar a evolução do paciente no arquivo.");
	                        }
	                    } else {
	                        System.out.println("Paciente não encontrado.");
	                    }
	                    break;
					case 16:
						System.out.println("Consultas pendentes de pagamento:");
	                    for (Patients paciente : patients) {
	                        List<Consulta> consultasPendentes = paciente.listarConsultasPendentes();
	                        if (!consultasPendentes.isEmpty()) {
	                            System.out.println("Paciente: " + paciente.getNome());
	                            for (Consulta consulta : consultasPendentes) {
	                                System.out.println("Data: " + consulta.getData() + ", Valor: " + consulta.getValor());
	                            }
	                        }
	                    }
						break;
					case 17:
						System.out.println("Digite o nome do paciente para listar sua evolução:");
	                    String nomePacienteEvolucaoList = sc.next();
	                    Patients pacienteEvolucaoList = sistema.buscarPacientePorNome(nomePacienteEvolucaoList);
	                    
	                    if(pacienteEvolucaoList != null) {
	                    	List<String> evolucaoPaciente = pacienteEvolucaoList.listarEvolucao(); 
	                    	if (!evolucaoPaciente.isEmpty()) {
	                    		System.out.println("Evolução do paciente " + pacienteEvolucaoList.getNome() + ":");
		                        for (String evolucao : evolucaoPaciente) {
		                            System.out.println(evolucao);
		                        }
	                    	}else {
	                    		System.out.println("Nenhuma evolução registrada para o paciente.");
	                    	}
	                    	
	                    } else {
	                        System.out.println("Paciente não encontrado.");
	                    }
						break;
					case 18:
						System.out.println("Emissão de Atestado Médico: ");
						
						sc.nextLine();
						System.out.print("Nome do paciente: ");
						String nomePacienteAtestado = sc.nextLine();
						System.out.println("Data do atestado (dd/mm/aaaa): ");
						String dataAtestado = sc.nextLine();
						System.out.println("Descrição médica: ");
						String descricaoMedica = sc.nextLine();
						
						AtestadoMedico atestado = new AtestadoMedico(nomePacienteAtestado, dataAtestado, descricaoMedica);
						
					    System.out.println("Atestado Médico Emitido:\n");
					    System.out.println(atestado);
					    
					    dataToSave = "Atestado Médico para " + atestado.getNomePaciente() + " em " + atestado.getDataAtestado() + ": " + atestado.getDescricaoMedica();
					    if (fileHandler.saveToFile(dataToSave)) {
					        System.out.println("Atestado Médico salvo com sucesso no arquivo.");
					    } else {
					        System.out.println("Erro ao salvar o Atestado Médico no arquivo.");
					    }
						break;
					case 19:
					    System.out.println("Emissão de Carnê de Pagamento");
					    
					    System.out.print("Nome do paciente: ");
					    String nomePacienteCarne = sc.next();
					    System.out.print("Valor da consulta: ");
					    double valorConsulta = sc.nextDouble();
					    System.out.print("Data de vencimento (dd/mm/aaaa): ");
					    String dataVencimento = sc.next();
					    
					    CarnePagamento carne = new CarnePagamento(nomePacienteCarne, valorConsulta, dataVencimento);
					    
					    System.out.println("Carnê de Pagamento Emitido:\n");
					    System.out.println(carne);
					    
					    dataToSave = "Carnê de Pagamento para " + carne.getNomePaciente() + " no valor de R$" + carne.getValorConsulta() + " com vencimento em " + carne.getDataVencimento();
					    if (fileHandler.saveToFile(dataToSave)) {
					        System.out.println("Carnê de Pagamento salvo com sucesso no arquivo.");
					    } else {
					        System.out.println("Erro ao salvar o Carnê de Pagamento no arquivo.");
					    }
					    break;
					case 20:
                        System.out.println("Emissão de Relatórios");

                        System.out.println("Escolha o tipo de relatório:");
                        System.out.println("1 - Relatório de Pacientes");
                        System.out.println("2 - Relatório de Consultas");
                        System.out.println("3 - Relatório de Evolução de Pacientes");
                        int tipoRelatorio = sc.nextInt();
                        sc.nextLine(); 

                        switch (tipoRelatorio) {
                            case 1:
                                String relatorioPacientes = Relatorio.gerarRelatorioPacientes(patients);
                                System.out.println(relatorioPacientes);
                                break;
                            case 2:
                                String relatorioConsultas = Relatorio.gerarRelatoriosConsultas(patients);
                                System.out.println(relatorioConsultas);
                                break;
                            case 3:
                                String relatorioEvolucao = Relatorio.gerarRelatorioEvolucao(patients);
                                System.out.println(relatorioEvolucao);
                                break;
                            default:
                                System.out.println("Tipo de relatório inválido.");
                                break;
                        }
                        break;
                    case 0:
                        System.out.println("Ending the program!");
                        sc.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option. Please try again!");
                        break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Por favor, insira um número válido.");
        } catch (DomainException e) {
            System.out.println(e.getMessage());
        } finally {
        	if (sc != null) {
                sc.close();
            }
        }
    }
}
