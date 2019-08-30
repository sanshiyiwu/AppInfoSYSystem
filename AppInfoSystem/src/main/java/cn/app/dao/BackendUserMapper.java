package cn.app.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.app.entity.BackendUser;

/**
 * 后台用户Dao层
 * @author lenovo
 *
 */
@Repository("backendUserMapper")
public interface BackendUserMapper {
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
	/**
	 *修改后台用户
	 */
	public Integer updBackendUser(BackendUser backendUser);
	/**
	 * 删除后台用户
	 */
	public Integer delBackendUser(Integer id);
}
