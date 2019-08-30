package cn.app.service;

import java.util.List;

import cn.app.entity.BackendUser;

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
<<<<<<< HEAD
=======
	/**
	 * 修改用户
	 * @param backendUser
	 * @return
	 */
	public Integer updBackendUser(BackendUser backendUser);
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	public Integer delBackendUser(Integer id);
	
>>>>>>> 2d2a908755195c40a52c0b3341f162e0e02aee6b
}
