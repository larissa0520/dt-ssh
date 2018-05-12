package com.xll.dt.dao.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.xll.dt.dao.SysConfigDao;
import com.xll.dt.dao.impl.BaseDAOImpl;
import com.xll.dt.pojo.SysConfig;

@Repository
public class SysConfigDaoImpl extends BaseDAOImpl<SysConfig> implements SysConfigDao {

    @Autowired
    public void setSF(SessionFactory sf) {
        //HibernateDaoSupport 为dao注入sessionFactory
        super.setSessionFactory(sf);
    }

    @Value("SysConfig")
    public void setClassName(String className) {
        super.className = className;
    }

    @Value("id")
    public void setKeyName(String keyName) {
        super.keyName = keyName;
    }

    @Value("id")
    public void setDefaultOrderColum(String defaultOrderColum) {
        super.defaultOrderColum = defaultOrderColum;
    }

    public List<SysConfig> find(Integer start, Integer rows) {
        String hql = "from SysConfig order by id asc";
        return super.find(hql, start, rows);
    }

    /**
     * 表中有关键字 key，hibernate自动生成的sql报错，自己写一个sql
     */
    @Override
    public Serializable save(SysConfig sysConfig) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("key", sysConfig.getKey());
        param.put("remark", sysConfig.getRemark());
        param.put("status", sysConfig.getStatus());
        param.put("value", sysConfig.getValue());
        String sql = "INSERT INTO sys_config (`key`, `remark`, `status`, `value`) VALUES (:key, :remark, :status, :value)";
        return super.executeSql(sql, param);
    }

    /**
     * 表中有关键字 key，hibernate自动生成的sql报错，自己写一个sql
     */
    @Override
    public void update(SysConfig sysConfig) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("id", sysConfig.getId());
        param.put("key", sysConfig.getKey());
        param.put("remark", sysConfig.getRemark());
        param.put("value", sysConfig.getValue());
        String sql = "update sys_config set `key` = :key, `value` = :value, remark = :remark where id = :id";
        super.executeSql(sql, param);
    }

    /**
     * 表中有关键字 key，hibernate自动生成的sql报错，自己写一个sql
     */
    @Override
    public List<SysConfig> findByKeyPrefix(String keyPrefix) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("keyPrefix", keyPrefix);
        String hql = "SELECT * FROM sys_config WHERE `key` LIKE :keyPrefix ORDER BY `key` asc";
        return super.nativeFind(hql, param);
    }

}
