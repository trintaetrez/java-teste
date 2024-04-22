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
		System.out.println("[0] - Sair\n[1] - Cadastrar funcionário");
		op = scanner.nextInt();
		
		while (op < 0 || op > 1) {
			System.out.println();
			System.out.println("Opção inválida. Digite novamente.");
			showMenu();
		}
	}
	
}
