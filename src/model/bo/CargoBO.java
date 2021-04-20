package model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.dao.CargoDAO;
import model.vo.CargoVO;

public class CargoBO {
	CargoDAO dao = new CargoDAO();
	
	public void inserir(CargoVO cargo) {
		if(cargo != null) {
			if(buscarNome(cargo) != null) {
				dao.inserir(cargo);
			} else {
				System.out.println("Cargo já existe");
			}
		}
	}
	
	public void remover(CargoVO cargo) {
		if(cargo != null) {
			if(buscarID(cargo) != null) {
				dao.remover(cargo);
			} else {
				System.out.println("Cargo não existe");
			}
		}
	}
	
	public void atualizar(CargoVO cargo, CargoVO novoCargo) {
		if(cargo != null && novoCargo != null) {
			if(buscarID(cargo) != null) {
				dao.atualizar(cargo, novoCargo);
			} else {
				System.out.println("Cargo não existe");
			}
		}
	}
	
	public CargoVO buscarID(CargoVO cargo) {
		ResultSet rs = dao.buscarID(cargo);
		
		try {
			if(rs.next()) {
				cargo.setID(rs.getLong("id"));
				cargo.setNome(rs.getString("nome"));
				cargo.setSalario(rs.getDouble("salario"));
			}
			return cargo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public CargoVO buscarNome(CargoVO cargo) {
		ResultSet rs = dao.buscarNome(cargo);
		
		try {
			if(rs.next()) {
				cargo.setID(rs.getLong("id"));
				cargo.setNome(rs.getString("nome"));
				cargo.setSalario(rs.getDouble("salario"));
			}
			return cargo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<CargoVO> listar() {
		ResultSet rs = dao.listar();
		List<CargoVO> list = new ArrayList<CargoVO>();
		
		try {
			while(rs.next()) {
				CargoVO cargo = new CargoVO();
				
				cargo.setID(rs.getLong("id"));
				cargo.setNome(rs.getString("nome"));
				cargo.setSalario(rs.getDouble("salario"));
				
				list.add(cargo);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}