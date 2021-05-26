package com.accenture.lkm.logservice;

import java.io.IOException;

import org.springframework.security.access.prepost.PreAuthorize;


public class DBLogService implements DBLog {
	
	@PreAuthorize ("hasRole('MSD_ADMIN') or hasRole('ROLE_MSD_DBA')") //Works fine	
	//@PreAuthorize ("ROLE_MSD_ADMIN,ROLE_MSD_DBA") //doesn't work fine as only Security expression language is supported..
	public String getLogs() throws IOException{
		String str="Logs are to read wait....";
		return str;
	}
	
}
