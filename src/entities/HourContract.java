package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HourContract {

	
	private Date date;
	private Double valuePerHour;
	private Integer hours;
	private Integer contractNumber;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public HourContract() {
	}

	public HourContract(Date date, Double valuePerHour, Integer hours, int contractNumber) {
		this.date = date;
		this.valuePerHour = valuePerHour;
		this.hours = hours;
		this.contractNumber = contractNumber;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getValuePerHour() {
		return valuePerHour;
	}

	public void setValuePerHour(Double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	public int getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(int contractNumber) {
		this.contractNumber = contractNumber;
	}

	public Double totalValue() {
		return valuePerHour * hours; 
	}
	
	public String toString() {
		return "#" + contractNumber + ": " + sdf.format(date) + ", valor por hora(R$): " + String.format("%.2f", valuePerHour) + ", total horas: " + hours + " horas , total do contrato(R$):  " + String.format("%.2f", totalValue());
	}
}
