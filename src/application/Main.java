package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Departament;
import entities.Worker;
import utilities.Menu;
import utilities.enums.WorkerLevel;

public class Main {

	public static void main(String[] args) {
		
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
			}
		}
		
		sc.close();
	}
	
	public static boolean hasId(List<Worker> list , int id) {
		Worker worker = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return worker != null;
	}

}
