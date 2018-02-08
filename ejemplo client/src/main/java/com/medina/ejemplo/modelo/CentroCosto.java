package com.medina.ejemplo.modelo;

import java.io.Serializable;

public class CentroCosto implements Serializable{

	private String codigo_cc;
	private String centro_costo;
	private double egresos;
	private double ingresos;
	private int year;
	
	public String getCodigo_cc() {
		return codigo_cc;
	}
	public void setCodigo_cc(String codigo_cc) {
		this.codigo_cc = codigo_cc;
	}
	public String getCentro_costo() {
		return centro_costo;
	}
	public void setCentro_costo(String centro_costo) {
		this.centro_costo = centro_costo;
	}
	public double getEgresos() {
		return egresos;
	}
	public void setEgresos(double egresos) {
		this.egresos = egresos;
	}
	public double getIngresos() {
		return ingresos;
	}
	public void setIngresos(double ingresos) {
		this.ingresos = ingresos;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	@Override
	public String toString() {
		return "CentroCosto [codigo_cc=" + codigo_cc + ", centro_costo="
				+ centro_costo + ", egresos=" + egresos + ", ingresos="
				+ ingresos + ", year=" + year + "]";
	}
	
	public CentroCosto(String codigo_cc, String centro_costo, double egresos,
			double ingresos, int year) {
		super();
		this.codigo_cc = codigo_cc;
		this.centro_costo = centro_costo;
		this.egresos = egresos;
		this.ingresos = ingresos;
		this.year = year;
	}
}
