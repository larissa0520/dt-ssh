package com.xll.dt.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xll.dt.pojo.SysMenu;
import com.xll.dt.service.SysMenuService;
import com.xll.dt.util.ShiroUtils;
import com.xll.dt.vo.DataGridResult;
import com.xll.dt.vo.Query;
import com.xll.dt.vo.R;

@Controller
@RequestMapping("/sys/menu")
public class SysMenuController {
  
	@Autowired
	private SysMenuService sysMenuService;
	
	@RequestMapping("/{page}")
	public String index(@PathVariable String page) {
		return "sys/menu/" +  page;
	}
	
	
	@RequestMapping("/list")
	@ResponseBody
	@RequiresPermissions({"sys:menu:list"})
	public DataGridResult getPage(@RequestParam Map<String, Object> params) {
		Query query = new Query(params);
		return sysMenuService.getPageList(query);
	}
    
    
    @RequestMapping("/delete")
    @ResponseBody
    @RequiresPermissions({"sys:menu:delete"})
    public R deleteBatch(@RequestBody Long[] ids) {
        sysMenuService.deleteBatch(ids);
        return R.ok();
    }
    
	@RequestMapping("/select")
	@ResponseBody
	@RequiresPermissions({"sys:menu:select"})
	public R getPage() {
		List<SysMenu> list = sysMenuService.getNotButtonList();
		return R.ok().put("menuList", list);
	}
	
	@RequestMapping("/save")
	@ResponseBody
	@RequiresPermissions({"sys:menu:save"})
	public R save(@RequestBody SysMenu menu) {
		sysMenuService.save(menu);
		return R.ok();
	}
    
	@RequestMapping("/info/{menuId}")
	@ResponseBody
	@RequiresPermissions({"sys:menu:info"})
	public R save(@PathVariable Long menuId) {
		SysMenu sysMenu = sysMenuService.getById(menuId);
		return R.ok().put("menu", sysMenu);
	}
    
	
	@RequestMapping("/update")
	@ResponseBody
	@RequiresPermissions({"sys:menu:update"})
	public R update(@RequestBody SysMenu menu) {
		sysMenuService.update(menu);
		return R.ok();
	}
	
	
	/**
	 * 角色授权菜单
	 */
	@RequestMapping("/select_all")
	@ResponseBody
	@RequiresPermissions({"sys:menu:perms"})
	public R all(){
		//查询列表数据
		List<SysMenu> menuList = sysMenuService.findAll();
		return R.ok().put("menuList", menuList);
	}
	
	
	@RequestMapping("/menu")
	@ResponseBody
	public R getTopMenuList(){
		/*List<SysMenu> menu = sysMenuService.getTopMenuList();*/
		List<SysMenu> menu = sysMenuService.findUserMenuList(ShiroUtils.getUserId());
		System.out.println("menu......."+menu);
		return R.ok().put("menu", menu);
	}
}
