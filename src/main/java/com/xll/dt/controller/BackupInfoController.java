package com.xll.dt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.xll.dt.service.BackupInfoService;

@Controller 
public class BackupInfoController {
	
	@Autowired
	private BackupInfoService backupInfoService;
}
