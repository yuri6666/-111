package com.winit.controller.manage;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.winit.common.baseclass.PageDto;
import com.winit.common.baseclass.ResultUtil;
import com.winit.common.constans.Constant;
import com.winit.common.utils.SessionUtil;
import com.winit.entity.dto.ResultDto;
import com.winit.entity.pojo.Income;
import com.winit.entity.pojo.Need;
import com.winit.entity.pojo.NeedNurse;
import com.winit.entity.pojo.User;
import com.winit.enums.UserType;
import com.winit.service.IncomeService;
import com.winit.service.NeedNurseService;
import com.winit.service.NeedService;

@RestController
@RequestMapping("/api/need")
public class NeedController {

	@Autowired
	private NeedService needService;
	@Autowired
	private IncomeService incomeService;
	
	@Autowired
	private NeedNurseService ndService;
	
	@RequestMapping(value="/geNeedList",method = RequestMethod.POST)
	public ResultDto list(Need need,HttpSession session){
		   User user= SessionUtil.getUserDetail(session);
          if(user!=null&&user.getType()==UserType.nurse.getValue()) {
              NeedNurse nd=new NeedNurse();
              nd.setNurseId(user.getId());
        	   List<NeedNurse> list=ndService.selective(nd);
        	   if(list!=null&&list.size()>0) {
        		   String idStr = "";
            	   for(NeedNurse nds:list) {
            		   idStr += ""+nds.getNeedId()+"" + ",";
            	   }
            	   idStr = idStr.substring(0, idStr.length()-1);
            	   need.setIdStr(idStr);
        	   }
        	   need.setAbilityId(user.getAbilityId());
        	   need.setAgeId(user.getAgeId());
        	   need.setCityCode(user.getCityCode());
        	   need.setCountyCode(user.getCountyCode());
        	   need.setNurseId(user.getId());
        	   need.setEducationId(user.getEducationId());
        	   need.setClassId(user.getClassId());
        	   need.setExperienceId(user.getExpericeId());
        	   need.setProvinceCode(user.getProvinceCode());
        	   need.setLevelId(user.getLevelId());
        	   need.setStatus(Constant.paystatus.PaymentsMade.getStatus());//能够获得已支付的单子 并且自己已经接单的单子
        	
          }
          if(user!=null&&user.getType()==UserType.customer.getValue()) {
        	  need.setCustomerId(user.getId());
          }
		PageDto<Need> pageDto = new PageDto<Need>();
		List<Need> list = needService.needList(need);
		PageInfo<Need> page = new PageInfo<Need>(list);
		pageDto.setTotal(page.getTotal());
		pageDto.setResult(list);
		return ResultUtil.success(pageDto, null);
	}
	@RequestMapping(value="/getAll",method = RequestMethod.POST)
	public ResultDto getAll(Need need){
		ResultDto resultDto=new ResultDto();
		List<Need> list = needService.needALL(need);
		if(list.size()>0) {
			resultDto.setResultCode("200");
			resultDto.setData(list);
		}
		return resultDto;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResultDto save(Need need){
		needService.save(need);
		return ResultUtil.success("保存成功");
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public ResultDto delete(Need need){
		List<Need> list = needService.needList(need);
		if(list.size()>0) {
			needService.delete(need.getId());
			 return ResultUtil.success("删除成功"); 
		}else {
			   return ResultUtil.fail("无法删除");  
		   }
	
			
}
	@RequestMapping(value = "/updateServer", method = RequestMethod.POST)
	public ResultDto updateServer(Need need){
		   NeedNurse nd =new NeedNurse();
		   nd.setNurseId(need.getNurseId());
		   nd.setNeedId(need.getId());
		    need.setStatus(Constant.paystatus.PaymentsMade.getStatus());
		    need.setNurseId(null);
		   ResultDto resultdto =new ResultDto();
           int result= needService.updateServer(need);
          if(result>0) {
        	  int result2=ndService.save(nd);
        	  resultdto.setResultCode("200");
        	  resultdto.setResultDesc("成功");
          }else { 
            	  resultdto.setResultCode("400");
            	  resultdto.setResultDesc("后台报错");
          }
          return resultdto;
	}
	
	
	@RequestMapping(value = "/updateselective", method = RequestMethod.POST)
	public ResultDto updateselective(Need need){
		  ResultDto resultdto =new ResultDto();
		if(need.getStatus()!=null&&need.getStatus().equals(Constant.paystatus.finished.getStatus())) {
			Income income=new Income();
			income.setCustomerId(need.getCustomerId());
			income.setNurseId(need.getNurseId());
			income.setMoney(need.getMoney());
			income.setCustomerName(need.getCustomerName());
			income.setNurseName(need.getNurseName());
			incomeService.save(income);
		}
		if(need.getNurseId()!=null&&need.getStatus()==Constant.paystatus.orderReceived.getStatus()) {
			Need nd =new Need();
			nd.setNurseId(need.getNurseId());
			nd.setStatus(Constant.paystatus.orderReceived.getStatus());
			List<Need> list = needService.needALL(nd);
			if(list!=null&&list.size()>0) {
				resultdto.setResultDesc("请先完成手头单子,才能再接单");
				return resultdto;
			}
		}
           int result= needService.updateselective(need);
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

