package entities;

import java.util.ArrayList;
import java.util.Calendar;
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
			int c_month = cal.get(Calendar.MONTH);
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
		int contador = 0;
		for (HourContract c : contracts) {
			contador++;
			System.out.println("Contrato #" + contador + ": " + c);
		}
	}
	
}
