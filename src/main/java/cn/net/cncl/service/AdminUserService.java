package cn.net.cncl.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.github.pagehelper.PageInfo;

import cn.net.cncl.entity.AdminUser;

public interface AdminUserService {

	/**
	 * 管理员信息<br>
	 * 查询
	 * 
	 * @param AdminUser.AdminUserName
	 */
	List<AdminUser> selectAdminUserByName(AdminUser adminUser);

	/**
	 * 管理员信息<br>
	 * 查询 分页
	 * 
	 * @param AdminUser.AdminUserName
	 */
	List<AdminUser> selectAdminUserByName(String adminUserName);

	PageInfo<AdminUser> selectAdminUserByName(String adminUserName, int pageNum);

	/**
	 * 添加 管理员信息
	 */
	int addAdminUser(HttpServletRequest request, AdminUser adminUser);

	/**
	 * 修改 管理员信息
	 */
	int editAdminUser(HttpServletRequest request, AdminUser adminUser);

	/**
	 * 新增管理员 登录名验证
	 * 
	 * @param @RequestParam
	 *            String adminUserName
	 */
	String checkAdminUserName(String adminUserName);

	/**
	 * 删除
	 */
	int deleteAdminUser(Long id);

	/**
	 * 查询ByID
	 */
	AdminUser queryById(Long id);

}
