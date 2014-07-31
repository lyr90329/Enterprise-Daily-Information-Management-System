package com.lyr.factory;

import com.lyr.dao.EmployeeDAO;
import com.lyr.daoImpl.EmployeeDAOImpl;

public class EmployeeDAOFactory {
	public static EmployeeDAO getEmployeeDAOInstance(){
		return new EmployeeDAOImpl();
	}
}
