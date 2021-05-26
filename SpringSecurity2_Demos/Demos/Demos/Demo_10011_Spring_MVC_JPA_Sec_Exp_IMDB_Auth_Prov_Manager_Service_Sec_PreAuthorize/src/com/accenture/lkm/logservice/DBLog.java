package com.accenture.lkm.logservice;

import java.io.IOException;

import org.springframework.security.access.prepost.PreAuthorize;

public interface DBLog {

	@PreAuthorize ("hasRole('ROLE_MSD_ADMIN') or hasRole('ROLE_MSD_DBA')")
	public String getLogs() throws IOException;

}