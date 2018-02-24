package com.xll.dt.service;



import com.xll.dt.pojo.SysUser;
import com.xll.dt.vo.DataGridResult;
import com.xll.dt.vo.Query;



public interface SysUserService {

	public DataGridResult getPageList(Query query);
	public void deleteBatch(Long[] userIds);
	public void save(SysUser user);
	public void update(SysUser user);
	public SysUser getByUsername(String username);
	public SysUser getById(Long userId);

}
