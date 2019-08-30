package cn.app.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.app.dao.AppVersionMapper;
import cn.app.entity.AppVersion;

/**
 * App版本信息业务层
 * @author Administrator
 *
 */
@Service("appVersionService")
@Transactional
public class AppVersionServiceImpl implements AppVersionService{
	
	@Resource
	private AppVersionMapper appVersionMapper;
	/**
	 * 通过appId查询App版本信息
	 * @param appId
	 * @return
	 */
	public List<AppVersion> getAppVersionListByAppId(Integer appId) {
		return appVersionMapper.getAppVersionListByAppId(appId);
	}
	/**
	 * 添加App版本信息
	 * @param id
	 * @return
	 */
	public Integer addAppVersion(AppVersion appVersion) {
		return appVersionMapper.addAppVersion(appVersion);
	}

}
