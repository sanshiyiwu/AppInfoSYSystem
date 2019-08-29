package cn.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.app.entity.BackendUser;
import cn.app.entity.DevUser;


/**
 * 开发者用户DAO层
 * @author lenovo
 *
 */
@Repository("devUserMapper")
public interface DevUserMapper {
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
	public Integer addDevUser(DevUser devuser);
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
}
