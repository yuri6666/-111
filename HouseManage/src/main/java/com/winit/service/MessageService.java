package com.winit.service;

import java.util.List;

import com.winit.entity.pojo.Message;

public interface MessageService {

	List<Message> messageList(Message message);

	List<Message> messageALL(Message message);

	int save(Message message);

	int updateselective(Message message);

	void delete(Integer id);

}
