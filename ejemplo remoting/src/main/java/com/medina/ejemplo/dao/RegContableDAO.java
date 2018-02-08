package com.medina.ejemplo.dao;

import java.util.List;

import com.medina.ejemplo.modelo.RegContable;

public interface RegContableDAO {
	
	boolean insertRegContable(RegContable regContable);
	
	boolean updateRegContable(RegContable regContable);
	
	boolean deleteRegContable(int id_reg);
	
	double getEgresosPorPeriodo(int year);
	
	double getIngresosPorPeriodo(int year);
	
	List<RegContable> getRegContablesPorMesYear(int mes, int year);
}
