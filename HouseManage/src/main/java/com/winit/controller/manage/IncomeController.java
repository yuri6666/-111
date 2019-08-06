package com.winit.controller.manage;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

import com.winit.common.baseclass.PageDto;
import com.winit.common.baseclass.ResultUtil;
import com.winit.common.constans.Constant;
import com.winit.common.utils.ExcelUtil;
import com.winit.common.utils.SessionUtil;
import com.winit.entity.dto.ResultDto;
import com.winit.entity.pojo.Income;
import com.winit.entity.pojo.User;
import com.winit.enums.UserType;
import com.winit.service.IncomeService;

@RestController
@RequestMapping("/api/income")
public class IncomeController {

	@Autowired
	private IncomeService incomeService;
	
	@RequestMapping(value="/geIncomeList",method = RequestMethod.POST)
	public ResultDto list(Income income,HttpSession session){
		   User user= SessionUtil.getUserDetail(session);
	          if(user.getType()!=null&&user.getType()==UserType.nurse.getValue()) {
	        	  income.setNurseId(user.getId());
	          }
		PageDto<Income> pageDto = new PageDto<Income>();
		List<Income> list = incomeService.incomeList(income);
		PageInfo<Income> page = new PageInfo<Income>(list);
		pageDto.setTotal(page.getTotal());
		pageDto.setResult(list);
		return ResultUtil.success(pageDto, null);
	}
	@RequestMapping(value="/getAll",method = RequestMethod.POST)
	public ResultDto getAll(Income income){
		ResultDto resultDto=new ResultDto();
		List<Income> list = incomeService.incomeALL(income);
		if(list.size()>0) {
			resultDto.setResultCode("200");
			resultDto.setData(list);
		}
		return resultDto;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResultDto save(Income income){
		incomeService.save(income);
		return ResultUtil.success("保存成功");
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public ResultDto delete(Income income){
		List<Income> list = incomeService.incomeList(income);
		if(list.size()>0) {
			incomeService.delete(income.getId());
			 return ResultUtil.success("删除成功"); 
		}else {
			   return ResultUtil.fail("无法删除");  
		   }
	
			
}
	@RequestMapping(value = "/updateselective", method = RequestMethod.POST)
	public ResultDto updateselective(Income income){
		   ResultDto resultdto =new ResultDto();
           int result= incomeService.updateselective(income);
          if(result>0) {
        	  resultdto.setResultCode("200");
        	  resultdto.setResultDesc("成功");
          }else { 
            	  resultdto.setResultCode("400");
            	  resultdto.setResultDesc("后台报错");
          }
          return resultdto;
	}
	@RequestMapping(value = "/export")
	private void export(HttpServletRequest request,
			HttpServletResponse response,Income income,HttpSession session)  {
		          List<Income> list=null;
		      
		          User user= SessionUtil.getUserDetail(session);
		          if(user.getType()!=null&&user.getType()==UserType.nurse.getValue()) {
		        	  income.setNurseId(user.getId());
		          }
		        if(income.getTimeType()==Constant.timeType.year.getTimeType()) {
		        	list=incomeService.grounpByYear(income);
		        }else if(income.getTimeType()==Constant.timeType.month.getTimeType()) {
		        	 list=incomeService.grounpByMonth(income);
		        }else if(income.getTimeType()==Constant.timeType.day.getTimeType()) {
		        	 list=incomeService.grounpByDay(income);
		        }else if(income.getTimeType()==Constant.timeType.quarter.getTimeType()) {
		        	 list=incomeService.grounpByquarter(income);
		        }
		        String[] title= {"时间","收益"};//excel标题
		 String fileName = "收益统计表"+System.currentTimeMillis()+".xls";//excel文件名
		 String sheetName = "收益统计表";//sheet名
			String[][] content = new String[list.size()][title.length];
	
			for(int i = 0;i < list .size(); i++) {
				content[i] = new String[title.length];
			Income obj = list .get(i);
	         content[i][0] = obj.getTime()== ""?"":obj.getTime().toString();
	         content[i][1] = obj.getMoney()== 0?"":Integer.toString(obj.getMoney());	        
		}
			HSSFWorkbook wb=null;
			if(income.getTimeType()==Constant.timeType.quarter.getTimeType()) {
				  String[] title2= {"季度","收益"};
				wb= ExcelUtil.getHSSFWorkbook(sheetName, title2, content, null);//创建HSSFWorkbook 
	        }else {
	        	 wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);//创建HSSFWorkbook 
	        }
		
		setResponseHeader(response, fileName);
		OutputStream os;
		try {
			os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	  //发送响应流方法
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
