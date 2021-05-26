package com.accenture.lkm.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.EmployeeBean;
import com.accenture.lkm.dao.EmployeeDAO;
import com.accenture.lkm.exceptions.InvalidUpdateOperationException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	public Integer addEmployee(EmployeeBean employeeBean) throws Exception {
		return employeeDAO.addEmployee(employeeBean);
	}

	public EmployeeBean getEmployeeDetails(Integer id) throws Exception {
		EmployeeBean emp = employeeDAO.getEmployeeDetails(id);
		if (emp == null) {
			throw new InvalidUpdateOperationException();
		}
		return emp;
	}

	public EmployeeBean updateEmployeeDetails(EmployeeBean employeeBean)
			throws Exception {
		EmployeeBean emp = employeeDAO.updateEmployeeDetails(employeeBean);
		return emp;
	}

	public EmployeeBean deleteEmployeeDetails(Integer id) throws Exception {
		EmployeeBean emp = employeeDAO.deleteEmployeeDetails(id);
		return emp;
	}

	public List<EmployeeBean> getEmployeeList() throws Exception {

		return employeeDAO.getEmployeeList();
	}

	// Assignment
	public List<EmployeeBean> getEmployeeDetailsWithin(Date startDate,Date endDate) throws Exception {
		return employeeDAO.getEmployeeDetailsWithin(startDate, endDate);
	}

	public Map<String,String> getAllEmployeeNameAndIds() throws Exception {
		return employeeDAO.getAllEmployeeNameAndIds();
	}

	public Integer deleteEmployeeByName(String name) throws Exception {
		return employeeDAO.deleteEmployeeByName(name);
	}

}
