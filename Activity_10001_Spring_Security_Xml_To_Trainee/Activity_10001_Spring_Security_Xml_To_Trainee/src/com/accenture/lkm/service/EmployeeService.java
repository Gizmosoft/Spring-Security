package com.accenture.lkm.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.accenture.lkm.business.bean.EmployeeBean;

public interface EmployeeService {

	Integer addEmployee(EmployeeBean employeeBean) throws Exception;

	EmployeeBean getEmployeeDetails(Integer id) throws Exception;

	EmployeeBean updateEmployeeDetails(EmployeeBean employeeBean)throws Exception;

	EmployeeBean deleteEmployeeDetails(Integer id) throws Exception;

	List<EmployeeBean> getEmployeeList() throws Exception;

	// Assignment
	List<EmployeeBean> getEmployeeDetailsWithin(Date startDate, Date endDate) throws Exception;
	Map<String,String> getAllEmployeeNameAndIds()throws Exception;
	Integer deleteEmployeeByName(String name) throws Exception;

}
