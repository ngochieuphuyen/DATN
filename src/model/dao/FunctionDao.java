package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conn.ConnectionUtils;
import model.bean.Function;

public class FunctionDao {
	Connection conn = ConnectionUtils.getConnection();

	public Function getFunction(int idFunction) {
		Function function = new Function();
		String sql = "select FunctionName, FunctionAddress, FunctionLogo from Functions where IdFunction =" + idFunction;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				function.setIdFunction(idFunction);
				function.setFunctionName(rs.getString("FunctionName"));
				function.setFunctionAddress(rs.getString("FunctionAddress"));
				function.setFunctionLogo(rs.getString("FunctionLogo"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return function;
	}

	public ArrayList<Function> getListFunctionFull() {
		ArrayList<Function> listFunction = new ArrayList<>();
		String sql = "select IdFunction, FunctionName from Functions";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Function function = new Function();
				function.setIdFunction(rs.getInt("IdFunction"));
				function.setFunctionName(rs.getString("FunctionName"));

				listFunction.add(function);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listFunction;
	}

}
