package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import utilities.enums.WorkerLevel;

public class Worker {
	
	private int id;
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	private Departament departament;
	private List<HourContract> contracts = new ArrayList<>();
	
	public Worker() {
	}

	public Worker(int id, String name, WorkerLevel level, Double baseSalary, Departament departament) {
		this.id = id;
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.departament = departament;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Departament getDepartament() {
		return departament;
	}

	public void setDepartament(Departament departament) {
		this.departament = departament;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	public void  addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	public double income(int year, int month) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		for(HourContract c : contracts) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = cal.get(Calendar.MONTH) + 1;
			if (year == c_year && month == c_month) {
				sum += c.totalValue();
			}
		}
		return sum;
	}
	
	public String toString() {
		return id + ", " + departament.getName() + ", " + name + ", " + level + ", " + String.format("%.2f", baseSalary);
	}
	
	public void aumentaSalario(double aumento) {
		baseSalary += ((baseSalary *  aumento) / 100); 
	}
	
	public void listarContratos() {
		for (HourContract c : contracts) {
			System.out.println("Contrato " + c);
		}
	}
	
	public int checkContracNumber2(int number) {
		int contador = 0;
		for (HourContract c : contracts) {
			if(c.getContractNumber() == number) {
				contador++;
			}
		}
		return contador;
	}
	
	public void removerContrato(int num) {
	    Iterator<HourContract> iterator = contracts.iterator();
	    while (iterator.hasNext()) {
	        HourContract contrato = iterator.next();
	        if (contrato.getContractNumber() == num) {
	            iterator.remove();
	            return; // Para sair do método após remover o contrato
	        }
	    }
	}
	
	public boolean tamanhoLista() {
		if(contracts.size() == 0) {
			return true;
		}
		else return false;
	}
	
	public void rendaTotal(String data) {
		int mes = Integer.parseInt(data.substring(0, 2));
		int ano = Integer.parseInt(data.substring(3));
		System.out.println("Nome: " + getName());
		System.out.println("Departamento: " + departament.getName());
		System.out.println("Renda de " + data + ": " + String.format("%.2f", income(ano, mes)) );
	}
	
}
