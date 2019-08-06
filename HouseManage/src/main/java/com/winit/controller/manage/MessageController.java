package com.winit.controller.manage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.winit.common.baseclass.PageDto;
import com.winit.common.baseclass.ResultUtil;
import com.winit.entity.dto.ResultDto;
import com.winit.entity.pojo.Message;
import com.winit.service.MessageService;

@RestController
@RequestMapping("/api/message")
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	@RequestMapping(value="/geMessageList",method = RequestMethod.POST)
	public ResultDto list(Message message){
		PageDto<Message> pageDto = new PageDto<Message>();
		List<Message> list = messageService.messageList(message);
		PageInfo<Message> page = new PageInfo<Message>(list);
		pageDto.setTotal(page.getTotal());
		pageDto.setResult(list);
		return ResultUtil.success(pageDto, null);
	}
	@RequestMapping(value="/getAll",method = RequestMethod.POST)
	public ResultDto getAll(Message message){
		ResultDto resultDto=new ResultDto();
		List<Message> list = messageService.messageALL(message);
		if(list.size()>0) {
			resultDto.setResultCode("200");
			resultDto.setData(list);
		}
		return resultDto;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResultDto save(Message message){
		messageService.save(message);
		return ResultUtil.success("保存成功");
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public ResultDto delete(Message message){
		List<Message> list = messageService.messageList(message);
		if(list.size()>0) {
			messageService.delete(message.getId());
			 return ResultUtil.success("删除成功"); 
		}else {
			   return ResultUtil.fail("无法删除");  
		   }
	
			
}
	@RequestMapping(value = "/updateselective", method = RequestMethod.POST)
	public ResultDto updateselective(Message message){
		   ResultDto resultdto =new ResultDto();
           int result= messageService.updateselective(message);
          if(result>0) {
        	  resultdto.setResultCode("200");
        	  resultdto.setResultDesc("成功");
          }else { 
            	  resultdto.setResultCode("400");
            	  resultdto.setResultDesc("后台报错");
          }
          return resultdto;
	}
}
