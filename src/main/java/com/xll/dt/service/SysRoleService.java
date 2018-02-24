package com.xll.dt.service;

import java.util.List;

import com.xll.dt.pojo.SysRole;
import com.xll.dt.vo.DataGridResult;
import com.xll.dt.vo.Query;

public interface SysRoleService {
	//分页业务方法
	DataGridResult getPageList(Query query);

	void save(SysRole role);

	void deleteBatch(Long[] ids);

	SysRole getById(Long roleId);

	void update(SysRole role);

	List<SysRole> findAll();

	List<String> selectRoleNameList(Long userId);
}
