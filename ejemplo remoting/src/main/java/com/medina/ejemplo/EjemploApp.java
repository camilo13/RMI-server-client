package com.medina.ejemplo;

import java.net.UnknownHostException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.remoting.rmi.RmiServiceExporter;

import com.medina.ejemplo.herramientas.PropertiesUtil;
import com.medina.ejemplo.interfaces.RegContableService;
import com.medina.ejemplo.interfaces.impl.RegContableServiceImpl;

@ComponentScan(basePackages = "com.medina.ejemplo.dao")
@Configuration
public class EjemploApp {
	
	Properties prop = PropertiesUtil.getProperties();

	@Bean
    public RegContableService regContableService() {
        return new RegContableServiceImpl();
    }
	
	@Bean
    public RmiServiceExporter exporter() throws UnknownHostException {
        RmiServiceExporter rse = new RmiServiceExporter();
        rse.setServiceName("RegContableService");
        rse.setService(regContableService());
        rse.setServiceInterface(RegContableService.class);
        rse.setRegistryPort(Integer.valueOf(prop.getProperty("servicio.puerto")));//Puerto configurable
        return rse;
    }
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(prop.getProperty("database.driver"));
		dataSource.setUrl(prop.getProperty("database.url")+"?autoReconnect=true");
		dataSource.setUsername(prop.getProperty("database.userName"));
		dataSource.setPassword(prop.getProperty("database.password"));
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	
	public static void main(String[] args) {
        new AnnotationConfigApplicationContext(EjemploApp.class);
    }
}
