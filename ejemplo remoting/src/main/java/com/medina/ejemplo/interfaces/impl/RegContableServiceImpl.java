package com.medina.ejemplo.interfaces.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.medina.ejemplo.dao.RegContableDAO;
import com.medina.ejemplo.interfaces.RegContableService;
import com.medina.ejemplo.modelo.CentroCosto;
import com.medina.ejemplo.modelo.RegContable;

/**
 * Los m�todos que se implementen ser�n llamados desde el cliente por medio de RMI (Java Remote Method Invocation)
 * 
 * @author Camil
 *
 */
public class RegContableServiceImpl implements RegContableService{

	@Autowired RegContableDAO regContableDAO;
	
	@Override
	public boolean insertRegContable(RegContable regContable) {
		if(regContableDAO.insertRegContable(regContable)) {
			System.out.println("Se registr�: " + regContable);
			return true;
		} else return false;
	}

	@Override
	public boolean updateRegContable(RegContable regContable) {
		if(regContableDAO.updateRegContable(regContable)) {
			System.out.println("Se edit� el registro N�: " + regContable.getId_reg());
			System.out.println(regContable);
			return true;
		} else return false;
	}

	@Override
	public boolean deleteRegContable(int id_reg) {
		if(regContableDAO.deleteRegContable(id_reg)) {
			System.out.println("Se elimin� el registro N�: " + id_reg);
			return true;
		} else return false;
	}

	@Override
	public CentroCosto getCentroCosto(int year) {
		System.out.println("Se consult� al centro de costo para el periodo: " + year);
		return new CentroCosto("00"+year, "RR. HH.", regContableDAO.getEgresosPorPeriodo(year), 
				regContableDAO.getIngresosPorPeriodo(year), year);
	}

	@Override
	public List<RegContable> getRegContablesPorMesYear(int mes, int year) {
		System.out.println("Se consult� al registro contable para el mes: " + mes + " y a�o: " + year);
		return regContableDAO.getRegContablesPorMesYear(mes, year);
	}
}
