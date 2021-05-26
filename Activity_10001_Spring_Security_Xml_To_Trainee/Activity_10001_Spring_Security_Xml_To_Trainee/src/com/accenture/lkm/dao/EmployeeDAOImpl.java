package com.accenture.lkm.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.business.bean.EmployeeBean;
import com.accenture.lkm.entity.EmployeeEntity;
@Repository
@SuppressWarnings("unchecked")
@Transactional("txManager")
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	

	public Integer addEmployee(EmployeeBean employeeBean) throws Exception{
		// TODO Auto-generated method stub
		Integer employeeID = 0;
		
		EmployeeEntity employeeEntityBean =convertBeanToEntity(employeeBean);
		try {
			entityManager.persist(employeeEntityBean);
			employeeID = employeeEntityBean.getId();
		} catch (Exception exception) {
			throw exception;
		}
		
		return employeeID;
	}
	
	public EmployeeBean getEmployeeDetails(Integer id) throws Exception{
		// TODO Auto-generated method stub
		EmployeeBean employeeBean = null;
		
		try {
			

			EmployeeEntity employeeEntity = (EmployeeEntity) entityManager.find(EmployeeEntity.class, id);

			if(employeeEntity!=null){
				employeeBean=convertEntityToBean(employeeEntity);
			}
			
		} catch (Exception exception) {

			throw exception;
		}
		

		return employeeBean;
	}
	
	
	
	public EmployeeBean updateEmployeeDetails(EmployeeBean employeeBean) throws Exception{
		// TODO Auto-generated method stub
		EmployeeBean employeeBean2 = null;
		
		try {
			
			EmployeeEntity employeeEntityBean2 = (EmployeeEntity) entityManager.find(EmployeeEntity.class, employeeBean.getId());

			if(employeeEntityBean2 != null)
			
			{
				
					employeeEntityBean2.setInsertTime(employeeBean.getInsertTime());
					employeeEntityBean2.setName(employeeBean.getName());
					employeeEntityBean2.setRole(employeeBean.getRole());
					employeeEntityBean2.setSalary(employeeBean.getSalary());
			
				employeeBean2 = convertEntityToBean(employeeEntityBean2);
			}
			
			
			

		} catch (Exception exception) {

			throw exception;
		}
		

		return employeeBean2;
	}

	public EmployeeBean deleteEmployeeDetails(Integer id) throws Exception{
		// TODO Auto-generated method stub
		EmployeeBean employeeBean = null;
		
		try {
			

			EmployeeEntity employeeEntity = (EmployeeEntity) entityManager.find(EmployeeEntity.class, id);

			if(employeeEntity != null)
			
			{
					entityManager.remove(employeeEntity);
			
				employeeBean =convertEntityToBean(employeeEntity);
			}			

		} catch (Exception exception) {

			throw exception;
		}
		

		return employeeBean;
	}
	
	
	public List<EmployeeBean> getEmployeeList() throws Exception{
		// TODO Auto-generated method stub
		List<EmployeeBean> listEmployeeBean = null;
		
		try {
			listEmployeeBean=new ArrayList<EmployeeBean>();
			
			List<EmployeeEntity> listEmployeeEntity= (List<EmployeeEntity>) entityManager.createQuery("from EmployeeEntity").getResultList();

			for (EmployeeEntity entity:listEmployeeEntity){
				EmployeeBean emp= convertEntityToBean(entity);
				listEmployeeBean.add(emp);
			}
			

		} catch (Exception exception) {

			throw exception;
		}
		
		//return employeeEntityBean2;
		return (listEmployeeBean);
	}
	
	//Assignment
	public List<EmployeeBean> getEmployeeDetailsWithin(Date startDate, Date endDate) throws Exception{
		// TODO Auto-generated method stub
		List<EmployeeBean> listEmployeeBean = null;	
		try {
			Query query = entityManager.createQuery("from EmployeeEntity k where k.insertTime between ? and ?");
				query.setParameter(1, startDate);
				query.setParameter(2, endDate);
				
			listEmployeeBean=new ArrayList<EmployeeBean>();
			List<EmployeeEntity> listEmployeeEntity= (List<EmployeeEntity>) query.getResultList();
			for (EmployeeEntity entity:listEmployeeEntity){
				EmployeeBean emp= convertEntityToBean(entity);
				listEmployeeBean.add(emp);
			}
		} catch (Exception exception) {
			throw exception;
		}
		return (listEmployeeBean);
	}
	
	
	
	
	public Integer deleteEmployeeByName(String name) throws Exception{
		// TODO Auto-generated method stub
		Integer result = null;	
		try {
			Query query = entityManager.createQuery("delete from EmployeeEntity k where k.name=?");
			query.setParameter(1, name);
			result=query.executeUpdate();
		} catch (Exception exception) {
			throw exception;
		}
		return result;
	}
	
	
	
	@Override
	public Map<String,String> getAllEmployeeNameAndIds() {
		Map<String,String> listEmployeeNames = null;	
		try {
			Query query = entityManager.createQuery("select k.name,k.id from EmployeeEntity k");		
			List<Object[]> empNamesAndId = query.getResultList();
			listEmployeeNames= new LinkedHashMap<String,String>();
			for(Object[] arr: empNamesAndId){
				int id=Integer.parseInt(arr[1]+"");
				String name=arr[0]+"";
				listEmployeeNames.put(name,"Name:"+name+", Id: "+id);
			}
		} catch (Exception exception) {
			throw exception;
		}
		return (listEmployeeNames);
	}
	

	public static EmployeeBean convertEntityToBean(EmployeeEntity entity){
		EmployeeBean employee = new EmployeeBean();
		BeanUtils.copyProperties(entity, employee);
		return employee;
	}
	public static EmployeeEntity convertBeanToEntity(EmployeeBean bean){
		EmployeeEntity employeeEntityBean = new EmployeeEntity();
		BeanUtils.copyProperties(bean,employeeEntityBean);
		return employeeEntityBean;
	}

	
	
	
}
