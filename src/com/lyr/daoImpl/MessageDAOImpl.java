package com.lyr.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lyr.bean.Message;
import com.lyr.dao.MessageDAO;
import com.lyr.util.DBConnection;
import com.lyr.util.Page;

public class MessageDAOImpl implements MessageDAO {

	@Override
	public void addMessage(Message message) {
		// TODO Auto-generated method stub
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into tb_message(messageTitle,messageContent,employeeID,publishTime) values(?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, message.getMessageTitle());
			pstmt.setString(2, message.getMessageContent());
			pstmt.setInt(3, message.getEmployeeID());
			pstmt.setDate(4, new java.sql.Date(message.getPublishTime().getTime()));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBConnection.close(pstmt);
			DBConnection.close(conn);
			
		}
	}

	@Override
	public void deleteMessage(Message message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMessage(Message message) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Message> findAllMessage(Page page) {
		// TODO Auto-generated method stub
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Message> messages = new ArrayList<Message>();
		String sql = "select * from tb_message order by publishTime desc limit ?,?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,page.getBeginIndex());
			pstmt.setInt(1,page.getEveryPage());
			rs = pstmt.executeQuery();
			if(rs.next()){
				Message message = new Message();
				message.setMessageID(rs.getInt(1));
				message.setMessageTitle(rs.getString(2));
				message.setMessageContent(rs.getString(3));
				message.setEmployeeID(rs.getInt(4));
				message.setPublishTime(rs.getDate(5));
				messages.add(message);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBConnection.close(pstmt);
			DBConnection.close(conn);
			
		}
		return messages;
	}

	@Override
	public Message findMessageById(int messageID) {
		// TODO Auto-generated method stub
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Message message = null;
		String sql = "select * from tb_message where messageID=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,messageID);
			rs = pstmt.executeQuery();
			if(rs.next()){
				message = new Message();
				message.setMessageID(rs.getInt(1));
				message.setMessageTitle(rs.getString(2));
				message.setMessageContent(rs.getString(3));
				message.setEmployeeID(rs.getInt(4));
				message.setPublishTime(rs.getDate(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBConnection.close(pstmt);
			DBConnection.close(conn);
			
		}
		return message;
	}

	@Override
	public int findAllCount() {
		// TODO Auto-generated method stub
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		String sql = "select count(*) from tb_message ";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
			
		}
		return count;
	}

}
