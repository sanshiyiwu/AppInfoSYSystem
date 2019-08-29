package cn.app.service;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.app.dao.BackendUserMapper;
import cn.app.entity.BackendUser;

/**
 * 后台用户Service实现层
 * @author lenovo
 *
 */
@Service("backendUserService")
@Transactional
public class BackendUserServiceImpl implements BackendUserService{
	/**
	 * 获取后台用户Mapper
	 */
	@Resource
	private BackendUserMapper backendUserMapper;
	/**
	 * 获取后台用户列表(登录)
	 */
	public List<BackendUser> getBackendUserList() {
		return backendUserMapper.getBackendUserList();
	}
	/**
	 * 增加后台用户(注册)
	 */
	public Integer addBackendUser(BackendUser backendUser) {
		return backendUserMapper.addBackendUser(backendUser);
	}
	/**
	 * 注册验证
	 */
	public BackendUser checkUserCode(String userCode) {
		return backendUserMapper.checkUserCode(userCode);
	}
	/**
	 * 根据ID查询后台用户
	 */
	public BackendUser getBackendUserById(Integer id) {
		return backendUserMapper.getBackendUserById(id);
	}
	/**
	 * 修改用户
	 */
	public Integer updBackendUser(BackendUser backendUser) {
		return backendUserMapper.updBackendUser(backendUser);
	}
	/**
	 * 删除用户
	 */
	public Integer delBackendUser(Integer id) {
		return backendUserMapper.delBackendUser(id);
	}
	
	
}
