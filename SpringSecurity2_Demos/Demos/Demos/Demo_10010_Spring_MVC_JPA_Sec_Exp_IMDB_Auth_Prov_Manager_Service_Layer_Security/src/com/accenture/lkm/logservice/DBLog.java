package com.accenture.lkm.logservice;

import java.io.IOException;

import javax.annotation.security.RolesAllowed;

import org.springframework.security.access.annotation.Secured;

public interface DBLog {
	
	//@Secured(value="ROLE_MSD_DBA")
	//@RolesAllowed(value="ROLE_MSD_DBA")
	public String getLogs() throws IOException;

}