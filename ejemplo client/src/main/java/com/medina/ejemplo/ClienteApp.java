package com.medina.ejemplo;

import java.net.UnknownHostException;
import java.util.Properties;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import com.medina.ejemplo.herramientas.PropertiesUtil;
import com.medina.ejemplo.interfaces.RegContableService;

@Configuration
public class ClienteApp {
	
	Properties prop = PropertiesUtil.getProperties();
	
	static Scanner sc = new Scanner(System.in);

	@Bean
    public RegContableBean regContableBean() {
        return new RegContableBean();
    }

    @Bean
    public RmiProxyFactoryBean exporter() throws UnknownHostException {
        RmiProxyFactoryBean rpfb = new RmiProxyFactoryBean();
        rpfb.setServiceInterface(RegContableService.class);
        String url = "rmi://" + prop.getProperty("server.ip") + ":" + prop.getProperty("server.puerto") + "/RegContableService";
        rpfb.setServiceUrl(url);
        return rpfb;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ClienteApp.class);
        RegContableBean bean = context.getBean(RegContableBean.class);
        menu(bean);        
    }
    
    private static void menu(RegContableBean bean){
    	boolean continuar = true;
    	System.out.println("== App RR. HH. - Módulo de transacciones contables == ");
    	System.out.println(" (1) Registrar | (2) Editar | (3) Eliminar | (4) Centro de costo | (5) Ver Por mes y año | (6) Salir ");
    	System.out.println("===================================================== ");
    	while (continuar){
	    	System.out.println("Ingrese un número: ");
	    	int op = sc.nextInt();
	    	switch (op) {
			case 1:
				bean.insertRegContable();
				break;
			case 2:
				bean.updateRegContable();
				break;
			case 3:
				bean.deleteRegContable();
				break;
			case 4:
				bean.getCentroCosto();
				break;
			case 5:
				bean.getRegContablesPorMesYear();
				break;
			case 6:
				continuar = false;
				System.out.println("-- Saliendo --");
				System.out.println("Hasta pronto...");
				break;
			default:
				System.out.println("-- Ingrese un número válido --");
				break;
			}
    	}
    }
	
}
