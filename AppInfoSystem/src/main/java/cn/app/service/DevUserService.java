package cn.app.service;

import java.util.List;

import cn.app.pojo.DevUser;
/**
 * 开发者用户Service层
 * @author lenovo
 *
 */
public interface DevUserService {
	/**
	 * 获取开发者用户列表(登录)
	 * @param user
	 * @return
	 */
	public List<DevUser> getDevUserList();
	/**
	 * 增加开发者用户(注册)
	 * @param user
	 * @return
	 */
	public Integer addDevUser(DevUser devUser);
	/**
	 * 根据ID查询开发者用户
	 * @param id
	 * @return
	 */
	public DevUser getDevUserById(Integer id);

}
