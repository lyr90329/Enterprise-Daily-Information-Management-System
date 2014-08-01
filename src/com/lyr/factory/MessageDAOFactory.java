package com.lyr.factory;

import com.lyr.dao.MessageDAO;
import com.lyr.daoImpl.MessageDAOImpl;

public class MessageDAOFactory {
	public static MessageDAO getMessageDAOInstance(){
		return new MessageDAOImpl();
	}
}
