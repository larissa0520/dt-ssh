package com.xll.dt.shiro;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xll.dt.pojo.SysConfig;
import com.xll.dt.service.SysConfigService;

public class FilterChainDefinitionMapBuilder {
	@Autowired
	private SysConfigService sysConfigService;
	
	public LinkedHashMap<String, String> buildFilter(){
		
		
		List<SysConfig> sysConfigList = sysConfigService.findByKeyPrefix("SHIRO_FILTER_CONFIG_%");
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		
		for (SysConfig sysConfig : sysConfigList) {
			String value = sysConfig.getValue();
			String[] array = value.split("=");
			map.put(array[0], array[1]);
		}
		/*
		map.put("/images/**", "anon");
		map.put("/css/**", "anon");
		map.put("/libs/**", "anon");
		map.put("/login.html", "anon");
		map.put("/sys/login", "anon");
		map.put("/kaptcha.jpg", "anon");
		map.put("/**", "user");*/
		return map;
	}
}

