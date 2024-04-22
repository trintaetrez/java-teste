package entities;

import java.util.ArrayList;
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
	
	
	

}
