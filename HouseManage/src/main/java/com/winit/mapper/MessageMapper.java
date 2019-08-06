package com.winit.mapper;

import java.util.List;

import com.winit.common.baseclass.MyMapper;
import com.winit.entity.pojo.Message;

public interface MessageMapper extends MyMapper<Message> {

	void deletebyId(Integer id);

	List<Message> messageList(Message message);

	List<Message> getAll(Message message);

	void updateSelective(Message message);

}
