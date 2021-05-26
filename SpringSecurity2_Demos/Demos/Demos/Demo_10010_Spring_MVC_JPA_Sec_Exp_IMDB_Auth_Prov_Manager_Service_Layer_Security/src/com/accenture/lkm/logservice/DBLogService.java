package com.accenture.lkm.logservice;

import java.io.IOException;

import javax.annotation.security.RolesAllowed;

import org.springframework.security.access.annotation.Secured;


public class DBLogService implements DBLog {
		    
	  @Secured({"ROLE_MSD_DBA","ROLE_MSD_ADMIN"})// change it hasRole(''); and observe it will stop working for dba even
	//@RolesAllowed({"ROLE_MSD_DBA","ROLE_MSD_ADMIN"})// change it hasRole(''); and observe it will stop working for dba even
	public String getLogs() throws IOException{
		String str="Logs are to read wait....";
		return str;
	}
	
}
