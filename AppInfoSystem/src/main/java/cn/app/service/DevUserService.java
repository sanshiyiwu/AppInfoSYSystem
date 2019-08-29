package cn.app.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.app.entity.DevUser;
import cn.app.entity.DevUser;
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
	 * 注册验证
	 * @param user
	 * @return
	 */
	public DevUser checkUserCode(@Param("devCode")String devCode);
	/**
	 * 根据ID查询开发者用户
	 * @param id
	 * @return
	 */
	public DevUser getDevUserById(Integer id);
	/**
	 * 修改用户
	 * @param DevUser
	 * @return
	 */
	public Integer updDevUser(DevUser devUser);
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	public Integer delDevUser(Integer id);

}
