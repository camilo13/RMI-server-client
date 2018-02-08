package com.medina.ejemplo;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.medina.ejemplo.interfaces.RegContableService;
import com.medina.ejemplo.modelo.CentroCosto;
import com.medina.ejemplo.modelo.RegContable;

public class RegContableBean {
	
	Scanner sc = new Scanner(System.in);

	//Los distintos m�todos de esta clase llaman a la implementaci�n de 'RegContableService' que solo se encuentra en el servidor.
	@Autowired RegContableService regContableService;
	
	public void insertRegContable() {
		
        System.out.println("-- Registro --");
        RegContable regContable = new RegContable();
        
        System.out.println("Ingrese el ID de registro contable a registrar: ");
        regContable.setId_reg(sc.nextInt());
        sc.nextLine();//Salto de linea
        
        System.out.println("Descripci�n: ");//Descripci�n del regsitro contable
        regContable.setDescripcion(sc.nextLine());
        
        System.out.println("Tipo (d/h): ");//DEBE O HABER
        regContable.setTipo(sc.next().toLowerCase().charAt(0));
        
        System.out.println("Monto (S/.): ");//Valor monetario del registro
        regContable.setMonto(sc.nextDouble());
        
        regContable.setFecha(LocalDate.now());//Inserta la fecha actual por default
        
        System.out.println("-- Insertando --");
        if(regContableService.insertRegContable(regContable)) System.out.println("-- Inserci�n OK --");
        else System.out.println("-- Error de inserci�n --");
    }
	
	public void updateRegContable() {
		
		System.out.println("-- Edici�n --");
        RegContable regContable = new RegContable();
        
        System.out.println("Ingrese el ID de registro contable a editar: ");
        regContable.setId_reg(sc.nextInt());
        sc.nextLine();//Salto de linea
        
        System.out.println("Descripci�n: ");//Descripci�n del regsitro contable
        regContable.setDescripcion(sc.nextLine());
        
        System.out.println("Tipo (d/h): ");//DEBE O HABER
        regContable.setTipo(sc.next().toLowerCase().charAt(0));
        
        System.out.println("Monto (S/.): ");//Valor monetario del registro
        regContable.setMonto(sc.nextDouble());
        
        regContable.setFecha(LocalDate.now());//Inserta la fecha actual por default
        
        System.out.println("-- Editando --");
        if(regContableService.updateRegContable(regContable)) System.out.println("-- Edici�n OK --");
        else System.out.println("-- Error de edici�n --");
	}
	
	public void deleteRegContable() {
		
		System.out.println("-- Borrar --");
        
        System.out.println("Ingrese el ID de registro contable a eliminar: ");
        int id_reg = sc.nextInt();
        sc.nextLine();//Salto de linea
        
        System.out.println("-- Eliminando --");
        if(regContableService.deleteRegContable(id_reg)) System.out.println("-- Eliminaci�n OK --");
        else System.out.println("-- Error de eliminaci�n --");
	}
	
	public void getCentroCosto() {
		
		System.out.println("-- Centro de costo --");
        
        System.out.println("Ingrese el a�o a consultar: ");
        int year = sc.nextInt();
        sc.nextLine();//Salto de linea
        
        System.out.println("-- Consultando al periodo: " + year + " --");
        CentroCosto cc = regContableService.getCentroCosto(year);
        System.out.println(cc);
	}
	
	public void getRegContablesPorMesYear() {
		
		System.out.println("-- Lista de registros contables --");
		
		System.out.println("Ingrese el mes a consultar (1 - 12): ");
		int mes = sc.nextInt();
        
        System.out.println("Ingrese el a�o a consultar: ");
		int year = sc.nextInt();
		sc.nextLine();//Salto de linea
		
		System.out.println("-- Consultando --");
		List<RegContable> regContables = regContableService.getRegContablesPorMesYear(mes, year);
		System.out.println("-- Se encontrar�n " + regContables.size() + " registros --");
        for(RegContable regContable : regContables){
        	System.out.println(regContable);
        }
	}
}
