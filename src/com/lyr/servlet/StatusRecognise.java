package com.lyr.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyr.bean.Employee;
import com.lyr.dao.EmployeeDAO;
import com.lyr.factory.EmployeeDAOFactory;

public class StatusRecognise extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		String employeeID = req.getParameter("employeeID");
		String password = req.getParameter("password");
		if(employeeID == null || "".equals(employeeID)){
			req.setAttribute("error", "请输入员工编号!");
			dispatcher = servletContext.getRequestDispatcher("/statusRecognise.jsp");
		}else{
			if(password == null || "".equals(password)){
				req.setAttribute("error", "请输入系统口令！");
				dispatcher = servletContext.getRequestDispatcher("/statusRecognise.jsp");
			}else{
				EmployeeDAO employeeDAO = EmployeeDAOFactory.getEmployeeDAOInstance();
				Employee employee = employeeDAO.findEmployeeById(Integer.parseInt(employeeID));
				if(employee == null){
					req.setAttribute("error", "员工编号不存在！");
					dispatcher = servletContext.getRequestDispatcher("/statusRecognise.jsp");
				}else{
					if(!password.equals(employee.getPassword())){
						req.setAttribute("error", "口令错误！");
						dispatcher = servletContext.getRequestDispatcher("/statusRecognise.jsp");
					}else{
						req.getSession().setAttribute("employee", employee);
						resp.sendRedirect("index.jsp");
						return;
					}
				}
			}
		}
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
