package com.winit.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.winit.entity.pojo.Message;
import com.winit.mapper.MessageMapper;
import com.winit.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

	@Resource
	private MessageMapper messageMapper;
	@Override
	public List<Message> messageList(Message message) {
		PageHelper.startPage(message.getPage(),message.getRows());
		return messageMapper.messageList(message);
	}

	@Override
	public int save(Message message) {
		if(message.getId()!=null) {
			return messageMapper.updateByPrimaryKeySelective(message);
		}
		 message.setCreateTime(new Date());
		 message.setIsEnable(0);
		return messageMapper.insertSelective(message);
	}
      
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		messageMapper.deletebyId(id);
	}

	@Override
	public List<Message> messageALL(Message message) {
		List<Message> list=messageMapper.getAll(message);
		return list;
	}

	@Override
	public int updateselective(Message message) {
		message.setReleaseTime(new Date());
		messageMapper.updateSelective(message);	
		return 1;
	}
	
	
}
