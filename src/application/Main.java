package application;

import java.util.Locale;
import java.util.Scanner;

import utilities.Menu;

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
		
		while (op != 0) {
			switch (op) {
			case 1:
				System.out.println("teste1");
				menu.showMenu();
				op = menu.getOp();
			}
		}
		
		sc.close();
	}

}
