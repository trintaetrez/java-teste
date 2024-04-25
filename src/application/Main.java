package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import utilities.Menu;
import utilities.enums.WorkerLevel;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@                               @@@");
		System.out.println("@@@   Jeba Bank of Brazil - JBB   @@@");
		System.out.println("@@@                               @@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println();
		System.out.println("Bem vindo ao sistema de controle de funcionários do JBB !!");
		
		Menu menu = new Menu(sc);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		menu.showMenu();
		
		int op = menu.getOp();
		
		List<Worker> workers = new ArrayList<>();
		
		while (op != 0) {
			switch (op) {
			case 1:
				System.out.print("Quantos funcionários vão ser cadastrados? ");
				int numFuncionarios = sc.nextInt();
				System.out.println();
				for (int i = 1; i <= numFuncionarios; i++) {
					System.out.println("Funcionário #" + i);
					System.out.print("Id: ");
					sc.nextLine();
					int id = sc.nextInt();
					while (hasId(workers, id)) {
						System.out.println();
						System.out.println("Id já cadastrado. Tente outro.");
						System.out.print("Id: ");
						id = sc.nextInt();
					}
					System.out.print("Departamento: ");
					sc.nextLine();
					String dep = sc.nextLine();
					System.out.print("Nome: ");
					String nome = sc.nextLine();
					System.out.print("Nível: ");
					System.out.println();
					System.out.println("[1] - Junior\n[2] - Pleno\n[3] - Senior");
					int nivelOp = sc.nextInt();
					while (nivelOp < 1 || nivelOp > 3) {
						System.out.println("Opção inválida. Tente Novamente.");
						System.out.println();
						System.out.println("[1] - Junior\n[2] - Pleno\n[3] - Senior");
						nivelOp = sc.nextInt();
					}
					String nivel = "";
					switch (nivelOp) {
						case 1: nivel = "JUNIOR";
						break;
						case 2 : nivel = "MID_LEVEL";
						break;
						case 3 : nivel = "SENIOR";
						break;
					}
					System.out.print("Salário: ");
					double salario = sc.nextDouble();
					workers.add(new Worker(id, nome, WorkerLevel.valueOf(nivel), salario, new Departament(dep)));
					System.out.println();
				}
				System.out.println("Cadastro feito com sucesso.");
				menu.showMenu();
				op = menu.getOp();
				break;
			case 2: 
				if (workers.size() == 0) {
					System.out.println("Nenhum funcionário cadastrado.");
				} else {
					System.out.println("Lista de funcionários:");
					System.out.println();
					
					for (Worker work : workers) {
						System.out.println(work.toString());
					}
				}
				menu.showMenu();
				op = menu.getOp();
				break;
			case 3 :
				if (workers.size() == 0) {
					System.out.println("Nenhum funcionário cadastrado.");
				} else {	
					System.out.println("Lista de funcionários:");
					System.out.println();
					
					for (Worker worker : workers) {
						System.out.println(worker.toString());
					}
					System.out.println();
					System.out.print("Digite o ID do funcionário que vai receber aumento: ");
					int id = sc.nextInt();
					
					if (hasId(workers, id)) {
						System.out.print("Digite a porcentagem: ");
						double porcentagem = sc.nextDouble();
						
						for (Worker worker : workers) {
							if (worker.getId() == id ) {
								worker.aumentaSalario(porcentagem);
							}
						}
					} else {
						System.out.println();
						System.out.println("Id não cadastrado.");
					}
				}
				menu.showMenu();
				op = menu.getOp();
				break;
			case 4:
				if (workers.size() == 0) {
					System.out.println("Nenhum funcionário cadastrado.");
				} else {
					System.out.println("Lista de funcionários:");
					System.out.println();
					
					for (Worker worker : workers) {
						System.out.println(worker.toString());
					}
					System.out.println();
					System.out.print("Digite o ID do funcionário que vai receber um contrato: ");
					int id = sc.nextInt();
					if (hasId(workers, id)) {
						System.out.print("Quantos contratos serão adicionados: ");
						int nContratos = sc.nextInt();
						
						for (int i = 1; i <= nContratos; i++) {
							System.out.println();
							System.out.println("Digite os dados do contrato #" + i);
							System.out.print("Número do contrato: ");
							int numeroContrato = sc.nextInt();
							
							for (Worker worker : workers) {
								if (worker.getId() == id ) {
									while(worker.checkContracNumber2(numeroContrato) != 0) {
										System.out.println();
										System.out.println("Contrato existente. Digite outro número.");
										System.out.print("Número do contrato: ");
										numeroContrato = sc.nextInt();
										}
								}
							}
							System.out.print("Data (DD/MM/YYYY): ");
							Date data = sdf.parse(sc.next());
							System.out.print("Valor por hora: ");
							double valorHora = sc.nextDouble();
							System.out.print("Duração (horas): ");
							int horas = sc.nextInt();
							
							for (Worker worker1 : workers) {
								if (worker1.getId() == id ) {
									worker1.addContract(new HourContract(data, valorHora, horas, numeroContrato));
								}
							}
						}
					} else {
						System.out.println();
						System.out.println("Id não cadastrado.");
					}
				}
				menu.showMenu();
				op = menu.getOp();
				break;
			case 5:
				if (workers.size() == 0) {
					System.out.println("Nenhum funcionário cadastrado.");
				} else {
					System.out.println("Lista de funcionários:");
					System.out.println();
					
					for (Worker worker : workers) {
						System.out.println(worker.toString());
					}
					System.out.println();
					System.out.print("Digite o ID do funcionário que vai ser removido um contrato: ");
					int id = sc.nextInt();
					System.out.println();
					if (hasId(workers, id)) {
						for (Worker worker : workers) {
							if (worker.getId() == id ) {
								if (worker.tamanhoLista()) {
									System.out.println("Nenhum contrato na lista.");
								} else {
								worker.listarContratos();
								System.out.println();
								System.out.print("Qual o número do contrato que você quer remover? ");
								int nContrato = sc.nextInt();

								
								for (Worker worker3 : workers) {
									if (worker.getId() == id ) {
										while(worker3.checkContracNumber2(nContrato) == 0) {
											System.out.println();
											System.out.println("Contrato inexistente. Digite outro número.");
											System.out.print("Número do contrato: ");
											nContrato = sc.nextInt();
										}
									}
								}
								
								for (Worker worker2 : workers) {
									if (worker2.checkContracNumber2(nContrato) != 0) {
										worker2.removerContrato(nContrato);
										System.out.println();
										System.out.println("Contrato removido.");
										}
									}
								
								}
							}
						}
					} else {
						System.out.println();
						System.out.println("Id não cadastrado.");
					}
				}
				menu.showMenu();
				op = menu.getOp();
				break;
			case 6:
				if (workers.size() == 0) {
					System.out.println("Nenhum funcionário cadastrado.");
				} else {
					System.out.println("Lista de funcionários:");
					System.out.println();
					
					for (Worker worker : workers) {
						System.out.println(worker.toString());
					}
					System.out.println();
					System.out.print("Digite o ID do funcionário para ver os contratos cadastrados: ");
					int id = sc.nextInt();
					System.out.println();
					if (hasId(workers, id)) {
							for (Worker worker : workers) {
								if(worker.tamanhoLista()) {
									System.out.println("Nenhum contrato na lista");
								} else {
									if (worker.getId() == id ) {
										worker.listarContratos();
								}
								}
						}
					} else {
						System.out.println();
						System.out.println("Id não cadastrado.");
					}
				}
				menu.showMenu();
				op = menu.getOp();
				break;
			case 7:
				if (workers.size() == 0) {
					System.out.println("Nenhum funcionário cadastrado.");
				} else {
					System.out.println("Lista de funcionários:");
					System.out.println();
					
					for (Worker worker : workers) {
						System.out.println(worker.toString());
					}
				}
				System.out.println();
				System.out.print("Digite o ID do funcionário para ver o seu salário total: ");
				int id = sc.nextInt();
				System.out.println();
				if (hasId(workers, id)) {
					for (Worker worker : workers) {
						if (worker.getId() == id) {
							System.out.print("Digite o mês e a data para calcular a renda: ");
							System.out.println();
							String mesEAno = sc.next();
							worker.rendaTotal(mesEAno);
						}
					}
				} else {
					System.out.println();
					System.out.println("Id não cadastrado.");
				}
				menu.showMenu();
				op = menu.getOp();
				break;
			}
		}
		System.out.println();
		System.out.println("Programa encerrado.");
		sc.close();
	}
	
	public static boolean hasId(List<Worker> list , int id) {
		Worker worker = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return worker != null;
	}

}
