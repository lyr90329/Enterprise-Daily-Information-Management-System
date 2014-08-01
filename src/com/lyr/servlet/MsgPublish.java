package com.lyr.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyr.bean.Employee;
import com.lyr.bean.Message;
import com.lyr.dao.MessageDAO;
import com.lyr.factory.MessageDAOFactory;

public class MsgPublish extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("gbk");
		ServletContext servletContext = req.getServletContext();
		RequestDispatcher dispatcher = null;
		String messageTitle = req.getParameter("title");
		String messageContent = req.getParameter("content");
		Employee employee = (Employee) req.getSession().getAttribute("employee");
		Date publishTime = new Date();
		if(employee == null){
			req.setAttribute("error", "发布消息需要登陆");
			dispatcher = servletContext.getRequestDispatcher("/publishNewMsg.jsp");
		}else{
			Message message = new Message();
			message.setMessageTitle(messageTitle);
			message.setMessageContent(messageContent);
			message.setEmployeeID(employee.getEmployeeID());
			message.setPublishTime(publishTime);
			MessageDAO messageDao = MessageDAOFactory.getMessageDAOInstance();
			messageDao.addMessage(message);
			dispatcher = servletContext.getRequestDispatcher("/GetMessageList.jsp");
		}
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
	}

}
