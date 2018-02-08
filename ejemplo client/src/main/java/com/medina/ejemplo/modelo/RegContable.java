package com.medina.ejemplo.modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class RegContable implements Serializable{
	private int id_reg;
	private LocalDate fecha;
	private String descripcion;
	private char tipo;//d: DEBE | h: HABER
	private double monto;
	
	public int getId_reg() {
		return id_reg;
	}
	public void setId_reg(int id_reg) {
		this.id_reg = id_reg;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public char getTipo() {
		return tipo;
	}
	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	
	@Override
	public String toString() {
		return "RegContable [id_reg=" + id_reg + ", fecha=" + fecha
				+ ", descripcion=" + descripcion + ", tipo=" + tipo
				+ ", monto=" + monto + "]";
	}
}
