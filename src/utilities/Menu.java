package utilities;

import java.util.Scanner;

public class Menu {

	private Scanner scanner;
	private int op;

	public Menu(Scanner scanner) {
		this.scanner = scanner;
	}

	public int getOp() {
		return op;
	}

	public void setOp(int op) {
		this.op = op;
	}
	
	public void showMenu() {
		
		System.out.println();
		System.out.println("Escolha a opção desejada:");
		System.out.println();
		System.out.println("[0] - Sair\n"
				+ "[1] - Cadastrar funcionário\n"
				+ "[2] - Listar funcionários cadastrados\n"
				+ "[3] - Aumento salarial\n"
				+ "[4] - Adicionar contrato\n"
				+ "[5] - Remover contrato\n"
				+ "[6] - Listar os contratos de um funcionário\n"
				+ "[7] - Salario total de um funcionario");
		op = scanner.nextInt();
		
		while (op < 0 || op > 7) {
			System.out.println();
			System.out.println("Opção inválida. Digite novamente.");
			showMenu();
		}
	}
	
}
