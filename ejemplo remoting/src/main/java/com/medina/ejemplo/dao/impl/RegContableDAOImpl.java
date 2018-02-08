package com.medina.ejemplo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.medina.ejemplo.dao.RegContableDAO;
import com.medina.ejemplo.modelo.RegContable;

@Component
public class RegContableDAOImpl implements RegContableDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public boolean insertRegContable(RegContable regContable) {
		String querySolicitud = "INSERT INTO reg_contables ("
				+ "id_reg, "
				+ "fecha, "
				+ "descripcion, "
				+ "tipo, "
				+ "monto"
				+ ") VALUES (?,?,?,?,?)";
		Object[] paramsSolicitud = new Object[] { 
				regContable.getId_reg(),
				regContable.getFecha().toString(),
				regContable.getDescripcion(),
				String.valueOf(regContable.getTipo()),
				regContable.getMonto()};
		try {
			jdbcTemplate.update(querySolicitud, paramsSolicitud);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean updateRegContable(RegContable regContable) {
		String query = "UPDATE reg_contables SET "
				+ "descripcion = ?, "
				+ "tipo = ?, "
				+ "monto = ? "
				+ "WHERE id_reg = ?";
		Object[] params = new Object[] {
				regContable.getDescripcion(),
				String.valueOf(regContable.getTipo()),
				regContable.getMonto(),
				regContable.getId_reg()};
		try {
			if(jdbcTemplate.update(query, params) == 0) return false;
			else return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteRegContable(int id_reg) {
		String deleteStatement = "DELETE FROM reg_contables WHERE id_reg = ?";
	    try{
	    	if(jdbcTemplate.update(deleteStatement, id_reg) == 0) return false;
	    	else return true;
	    }catch (Exception e) {
	    	e.printStackTrace();
	    	return false;
		}
	}

	@Override
	public double getEgresosPorPeriodo(int year) {
		String sql = "SELECT SUM(monto) FROM reg_contables WHERE YEAR(fecha) = ? AND tipo = 'd'";
		try {
			return (jdbcTemplate.queryForObject(sql, Double.class, year));
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public double getIngresosPorPeriodo(int year) {
		String sql = "SELECT SUM(monto) FROM reg_contables WHERE YEAR(fecha) = ? AND tipo = 'h'";
		try {
			return (jdbcTemplate.queryForObject(sql, Double.class, year));
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public List<RegContable> getRegContablesPorMesYear(int mes, int year) {
		String sql = "SELECT * FROM reg_contables WHERE MONTH(fecha) = ? AND YEAR(fecha) = ?";
		List<RegContable> auxs = jdbcTemplate.query(sql, new Object[]{mes, year}, new RowMapper<RegContable>() {
			public RegContable mapRow(ResultSet rs, int rowNum) throws SQLException {
				RegContable aux = new RegContable();
				aux.setId_reg(rs.getInt("id_reg"));
				aux.setFecha(rs.getDate("fecha").toLocalDate());
				aux.setDescripcion(rs.getString("descripcion"));
				aux.setTipo(rs.getString("tipo").charAt(0));
				aux.setMonto(rs.getDouble("monto"));
				return aux;
			}
		});
		return auxs;
	}
}
