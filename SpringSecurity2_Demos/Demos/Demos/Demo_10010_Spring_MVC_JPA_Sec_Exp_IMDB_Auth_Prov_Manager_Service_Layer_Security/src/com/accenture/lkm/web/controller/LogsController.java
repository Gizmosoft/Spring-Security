package com.accenture.lkm.web.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.logservice.DBLog;

@Controller
public class LogsController {
	
	@Autowired
	private DBLog db;
	
	@RequestMapping(value = "/ReadLogs", method = RequestMethod.GET)
	public ModelAndView readLogs() {

		ModelAndView model = new ModelAndView();
		try {
			model.addObject("logData", db.getLogs());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.setViewName("Log");
		return model;

	}
	

}