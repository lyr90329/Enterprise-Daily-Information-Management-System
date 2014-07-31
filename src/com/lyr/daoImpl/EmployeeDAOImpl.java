package com.lyr.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.lyr.bean.Employee;
import com.lyr.dao.EmployeeDAO;
import com.lyr.util.DBConnection;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee findEmployeeById(int employeeID) {
		// TODO Auto-generated method stub
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Employee employee = null;
		String sql = "select * from tb_employee where employeeID=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, employeeID);
			rs = pstmt.executeQuery();
			if(rs.next()){
				employee = new Employee();
				employee.setEmployeeID(rs.getInt(1));
				employee.setEmployeeName(rs.getString(2));
				employee.setEmployeeSex(rs.getBoolean(3));
				employee.setEmployeeBirth(rs.getDate(4));
				employee.setEmployeePhone(rs.getString(5));
				employee.setEmployeePlace(rs.getString(6));
				employee.setJoinTime(rs.getDate(7));
				employee.setPassword(rs.getString(8));
				employee.setLead(rs.getBoolean(9));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return employee;
	}

	@Override
	public List<Employee> findAllEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

}
