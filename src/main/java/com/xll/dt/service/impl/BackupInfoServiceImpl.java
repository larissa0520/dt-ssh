package com.xll.dt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xll.dt.dao.BackupInfoDao;
import com.xll.dt.service.BackupInfoService;

@Service
public class BackupInfoServiceImpl implements BackupInfoService{
   @Autowired
   private  BackupInfoDao backupInfoDao ;
}
