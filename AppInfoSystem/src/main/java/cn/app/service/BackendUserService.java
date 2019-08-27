package cn.app.service;

import java.util.List;

import cn.app.pojo.BackendUser;

/**
 * 后台用户Service层
 * @author lenovo
 *
 */
public interface BackendUserService {
	/**
	 * 获取后台用户列表(登录)
	 * @param user
	 * @return
	 */
	public List<BackendUser> getBackendUserList();
	/**
	 * 增加后台用户(注册)
	 * @param user
	 * @return
	 */
	public Integer addBackendUser(BackendUser backendUser);
	/**
	 * 根据ID查询后台用户
	 * @param id
	 * @return
	 */
	public BackendUser getBackendUserById(Integer id);
}
