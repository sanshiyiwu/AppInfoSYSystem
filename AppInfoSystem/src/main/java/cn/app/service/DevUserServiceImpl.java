package cn.app.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.app.dao.DevUserMapper;
import cn.app.entity.DevUser;
import cn.app.entity.DevUser;

/**
 * 开发者用户Service实现层
 * @author lenovo
 *
 */
@Service("devUserService")
@Transactional
public class DevUserServiceImpl implements DevUserService {
	/**
	 * 获取DevUserMapper
	 */
	@Resource
	private DevUserMapper devUserMapper;
	/**
	 * 获取开发者用户列表(登录)
	 */
	public List<DevUser> getDevUserList() {
		return devUserMapper.getDevUserList();
	}
	/**
	 * 增加开发者用户(注册)
	 */
	public Integer addDevUser(DevUser devUser) {
		return devUserMapper.addDevUser(devUser);
	}
	/**
	 * 注册验证
	 */
	public DevUser checkUserCode(String devCode) {
		return devUserMapper.checkUserCode(devCode);
	}
	/**
	 * 根据ID查询开发者用户
	 */
	public DevUser getDevUserById(Integer id) {
		return devUserMapper.getDevUserById(id);
	}
	/**
	 * 修改用户
	 */
	public Integer updDevUser(DevUser devUser) {
		return devUserMapper.updDevUser(devUser);
	}
	/**
	 * 删除用户
	 */
	public Integer delDevUser(Integer id) {
		return devUserMapper.delDevUser(id);
	}
	
	
}
