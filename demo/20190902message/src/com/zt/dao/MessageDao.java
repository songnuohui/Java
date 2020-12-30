package com.zt.dao;
import java.util.List;

import com.zt.po.Message;
public interface MessageDao {
   public boolean addMessage(Message message);
   
   public Message getMessageById(int messageId);
   public boolean updateMessage(Message message);
   
   public boolean delMessage(int messageId);
   
   public List<Message> findAll();
   
}
