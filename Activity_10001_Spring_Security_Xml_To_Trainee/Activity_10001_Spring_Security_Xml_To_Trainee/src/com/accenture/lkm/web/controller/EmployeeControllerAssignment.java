package com.accenture.lkm.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.business.bean.EmployeeBean;
import com.accenture.lkm.exceptions.InvalidUpdateOperationException;
import com.accenture.lkm.service.EmployeeService;

@Controller

@SuppressWarnings("unused")
public class EmployeeControllerAssignment {

	@Autowired
	private EmployeeService employeeService;

	//https://stackoverflow.com/questions/20616319/the-request-sent-by-the-client-was-syntactically-incorrect-spring-mvc-jdbc-te
	//this is required to share the date for update on multiple submissions
	// otherwise Spring will not know how to parse date from date to String and vice versa
	// in subsequent request submissions
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");	    
	    //binder.registerCustomEditor(Date.class,"insertTime", new CustomDateEditor(sdf, true));
	    //For all the date fields being submitted
	    binder.registerCustomEditor(Date.class,new CustomDateEditor(sdf, true));
	}
	@RequestMapping(value = "/LoadGetDetailsInDateRange", method = RequestMethod.GET)
	public ModelAndView getEmployeesWithinDateRangePage() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("GetEmployeeDetailsByDateRange");
		modelAndView.addObject("empList", null);
		return modelAndView;
	}
	@RequestMapping(value = "/GetDataWithinDateRange", method = RequestMethod.GET)
	public ModelAndView getEmployeesDataInDateRange(@RequestParam("fromDate")Date startDate,@RequestParam("toDate")Date endDate) throws Exception {
		List<EmployeeBean> list = employeeService.getEmployeeDetailsWithin(startDate, endDate);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("GetEmployeeDetailsByDateRange");
		modelAndView.addObject("empList", list);
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/LoadDeleteEmployeeByName", method = RequestMethod.GET)
	public ModelAndView getDeleteEmployeesByNamePage() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("DeleteEmployee");
		modelAndView.addObject("employeeBean", new EmployeeBean());

		// 1 Dynamic DropDown - Different Labels and values 
		//[Map key->value of control, Map value-> label of control]
		System.out.println("**Name and Id Map Initialized***");
		modelAndView.addObject("employeeNamesAndId",employeeService.getAllEmployeeNameAndIds());
		return modelAndView;
	}

	
	
	@RequestMapping(value = "/DeleteEmployeeByName", method = RequestMethod.POST)
	public ModelAndView deleteEmployeesByName(@ModelAttribute("employeeBean")EmployeeBean bean) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("DeleteEmployee");
		int res=employeeService.deleteEmployeeByName(bean.getName());
		modelAndView.addObject("employeeBean", new EmployeeBean());
		if(res==0){
			modelAndView.addObject("message", "Please select valid Employee");
		}
		else{
			modelAndView.addObject("message", "Employee with Name:"+bean.getName()+" Deleted Successfully");
			//rest the employeeNameAndIdList after successful deletion
			// 1 Dynamic DropDown - Different Labels and values 
			//[Map key->value of control, Map value-> label of control]
			System.out.println("**Name and Id Map Initialized***");
			modelAndView.addObject("employeeNamesAndId",employeeService.getAllEmployeeNameAndIds());
		}
		
		return modelAndView;
	}
	

	
	
	//Error Handler:
	@ExceptionHandler(value=Exception.class)
	public ModelAndView handleAllExceptions(Exception exception){
		
		ModelAndView  modelAndView = new ModelAndView();
		modelAndView.setViewName("GeneralizedExceptionHandlerPage");
		modelAndView.addObject("message", exception.getMessage());
		modelAndView.addObject("exception", exception);
		return modelAndView;
	}
	
}
