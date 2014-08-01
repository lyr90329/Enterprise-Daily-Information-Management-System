package com.lyr.dao;

import java.util.List;
import com.lyr.bean.Message;
import com.lyr.util.Page;

public interface MessageDAO {
	public void addMessage(Message message);
	public void deleteMessage(Message message);
	public void updateMessage(Message message);
	public List<Message> findAllMessage(Page page);
	public Message findMessageById(int messageID);
	public int findAllCount();
}
