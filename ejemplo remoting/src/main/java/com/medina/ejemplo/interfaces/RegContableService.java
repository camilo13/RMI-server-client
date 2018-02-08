package com.medina.ejemplo.interfaces;

import java.util.List;

import com.medina.ejemplo.modelo.CentroCosto;
import com.medina.ejemplo.modelo.RegContable;

public interface RegContableService {
	
	boolean insertRegContable(RegContable regContable);
	
	boolean updateRegContable(RegContable regContable);
	
	boolean deleteRegContable(int id_reg);
	
	CentroCosto getCentroCosto(int year);
	
	List<RegContable> getRegContablesPorMesYear(int mes, int year);
}
